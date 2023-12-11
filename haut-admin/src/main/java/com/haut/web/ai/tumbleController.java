package com.haut.web.ai;
import com.alibaba.fastjson.JSONArray;
import com.haut.common.DataEntity.*;
import com.haut.common.constant.HttpStatus;
import com.haut.common.core.AjaxResult;
import com.haut.yolo.models.tumbleYolo;
import com.haut.yolo.utils.utils;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Base64;


@RestController
@CrossOrigin
@RequestMapping("/tumble")
public class tumbleController {

    public String matToBase64(Mat mat) {
        MatOfByte matOfByte = new MatOfByte();
        Imgcodecs.imencode(".jpg", mat, matOfByte);

        // 将MatOfByte转换为字节数组
        byte[] byteArray = matOfByte.toArray();

        // 使用Base64编码
        String base64String = Base64.getEncoder().encodeToString(byteArray);

        return base64String;
    }

    @Autowired
    tumbleYolo tumbleYolo;



    @PostMapping("/processImg")
    public AjaxResult predict(@RequestBody ImageData imageData){

        // 解码 Base64 图像数据
        byte[] decodedBytes = Base64.getDecoder().decode(imageData.getImageData().split(",")[1]);

        Mat image = Imgcodecs.imdecode(new MatOfByte(decodedBytes), Imgcodecs.IMREAD_UNCHANGED);
        if(!image.empty()){
            try{
                JSONArray predict = tumbleYolo.predict(image);
                Mat mat = utils.drawBoundingBoxesOnMat(image, predict);
                return AjaxResult.success("操作成功", matToBase64(mat));
            }catch (Exception e){
                e.printStackTrace();
                System.out.println("预测有误");
                return AjaxResult.error("预测出现问题");
            }
        }else{
            return AjaxResult.error("解码图像失败");
        }


    }

}
