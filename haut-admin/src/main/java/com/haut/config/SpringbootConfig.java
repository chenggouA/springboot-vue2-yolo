package com.haut.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({YoloConfig.class})
public class SpringbootConfig {

}
