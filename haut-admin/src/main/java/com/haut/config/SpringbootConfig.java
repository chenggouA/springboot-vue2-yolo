package com.haut.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

@Configuration
public class SpringbootConfig {

    @Bean
    public SimpleDateFormat formatter(){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }


}
