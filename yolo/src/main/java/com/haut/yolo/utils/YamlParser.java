package com.haut.yolo.utils;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;

public class YamlParser {

    public  Integer imgsz;
    public  ArrayList<String> classes;

    public  float nmsThreshold;
    public  float confThreshold;



    public YamlParser(String filePath) {
        URL resource = ClassLoader.getSystemResource(filePath);

        try (InputStream input = resource.openStream()) {
            Yaml yaml = new Yaml();
            // 使用 load 方法解析 YAML 文件
            Map<String, Object> load = yaml.load(input);
            imgsz = (Integer) load.get("imgsz");
            classes = (ArrayList<String>) load.get("names");
            nmsThreshold = ((Number) load.get("nmsThreshold")).floatValue();
            confThreshold = ((Number) load.get("confThreshold")).floatValue();


        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
