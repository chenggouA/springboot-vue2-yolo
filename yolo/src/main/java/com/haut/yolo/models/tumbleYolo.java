package com.haut.yolo.models;


import ai.onnxruntime.*;
import com.alibaba.fastjson.JSONArray;

import com.haut.yolo.utils.YamlParser;
import com.haut.yolo.utils.utils;
import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import java.net.URL;
import java.nio.FloatBuffer;

import java.util.*;

public class tumbleYolo {
    OrtEnvironment env;
    OrtSession session;
    long count;
    long channels;
    Integer netHeight;
    Integer netWidth;

    float nmsThreshold ;
    float confThreshold ;
    ArrayList<String> classes;

    private final String onnxModel = "model/tumble.onnx";
    private final String opencvDll = "lib/opencv/opencv_java455.dll";
    private final String tumbleYaml = "conf/down.yaml";



    private void initParam(){
        YamlParser yamlParser = new YamlParser(tumbleYaml);
        netHeight = yamlParser.imgsz;
        netWidth = yamlParser.imgsz;
        nmsThreshold = yamlParser.nmsThreshold;
        confThreshold = yamlParser.confThreshold;
        classes = yamlParser.classes;
    }
    public tumbleYolo(){

        // 初始化参数
        initParam();
        URL resource = ClassLoader.getSystemResource(onnxModel);
        final String path = resource.getPath().substring(1);
        try{

            env = OrtEnvironment.getEnvironment();

            // 使用GPU 进行推理
            OrtSession.SessionOptions sessionOptions = new OrtSession.SessionOptions();
            sessionOptions.addCUDA(0);
            session = env.createSession(path, sessionOptions);


            OnnxModelMetadata metadata = session.getMetadata();
            Map<String, NodeInfo> infoMap = session.getInputInfo();
            TensorInfo nodeInfo = (TensorInfo)infoMap.get("images").getInfo();
            System.out.println("-------打印模型信息开始--------");
            System.out.println("getProducerName="+metadata.getProducerName());
            System.out.println("getGraphName="+metadata.getGraphName());
            System.out.println("getDescription="+metadata.getDescription());
            System.out.println("getDomain="+metadata.getDomain());
            System.out.println("getVersion="+metadata.getVersion());
            System.out.println("getCustomMetadata="+metadata.getCustomMetadata());
            System.out.println("getInputInfo="+infoMap);
            System.out.println("nodeInfo="+nodeInfo);
            System.out.println("-------打印模型信息结束--------");
            count = nodeInfo.getShape()[0];//1 模型每次处理一张图片
            channels = nodeInfo.getShape()[1];//3 模型通道数


//            netHeight = nodeInfo.getShape()[2];//640 模型高
//            netWidth = nodeInfo.getShape()[3];//640 模型宽

            // 加载动态库
            URL url = ClassLoader.getSystemResource(opencvDll);
            System.load(url.getPath());
        }
        catch (Exception e){
            e.printStackTrace();
            System.exit(0);
        }
    }


    public  Mat readImg(String path){
        Mat img = Imgcodecs.imread(path);
        return img;
    }



    private OnnxTensor transferTensor(Mat dst){
        Imgproc.cvtColor(dst, dst, Imgproc.COLOR_BGR2RGB);
        dst.convertTo(dst, CvType.CV_32FC1, 1. / 255);
        float[] whc = new float[ Long.valueOf(channels).intValue() * Long.valueOf(netWidth).intValue() * Long.valueOf(netHeight).intValue() ];
        dst.get(0, 0, whc);
        float[] chw = utils.whc2cwh(whc);
        OnnxTensor tensor = null;
        try {
            tensor = OnnxTensor.createTensor(env, FloatBuffer.wrap(chw), new long[]{count,channels,netWidth,netHeight});
        }
        catch (Exception e){
            e.printStackTrace();
            System.exit(0);
        }
        return tensor;
    }

    public JSONArray predict(Mat src) throws OrtException {
        int srcw = src.width();
        int srch = src.height();
        Mat dst = utils.resizeWithPadding(src, netWidth, netHeight);
        OnnxTensor tensor = transferTensor(dst);


        OrtSession.Result result = session.run(Collections.singletonMap("images", tensor));
        OnnxTensor res = (OnnxTensor)result.get(0);
        float[][][] dataRes = (float[][][])res.getValue();
        float[][] data = dataRes[0];
        JSONArray srcRec = utils.filterRec1(data,  confThreshold, classes, netWidth, netHeight);
        JSONArray srcRec2 = utils.filterRec2(srcRec, nmsThreshold);
        JSONArray dstRec = utils.transferSrc2Dst(srcRec2,srcw,srch,  netWidth, netHeight);
        System.out.println(dstRec);

        return dstRec;

    }


    @Override
    public String toString() {
        return "tumbleYolo{" +
                "count=" + count +
                ", channels=" + channels +
                ", netHeight=" + netHeight +
                ", netWidth=" + netWidth +
                ", nmsThreshold=" + nmsThreshold +
                ", confThreshold=" + confThreshold +
                ", classes=" + classes +
                '}';
    }
}