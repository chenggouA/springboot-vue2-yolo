package com.haut.config;


import com.haut.yolo.models.tumbleYolo;
import org.springframework.context.annotation.Bean;

public class YoloConfig {

    @Bean
    public tumbleYolo tumbleYolo(){
        tumbleYolo tumbleYolo = new tumbleYolo();
        return tumbleYolo;

    }
}
