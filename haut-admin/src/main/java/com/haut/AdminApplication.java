package com.haut;

import com.haut.yolo.models.tumbleYolo;
import com.haut.yolo.utils.YamlParser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;

@SpringBootApplication
public class AdminApplication {

    public static void main(String[] args) throws  Exception{
        ConfigurableApplicationContext run = SpringApplication.run(AdminApplication.class, args);

    }

}
