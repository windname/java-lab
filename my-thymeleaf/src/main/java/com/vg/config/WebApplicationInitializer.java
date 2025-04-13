package com.vg.config;

import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

public class WebApplicationInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        if (applicationContext instanceof AnnotationConfigServletWebServerApplicationContext) {
            ((AnnotationConfigServletWebServerApplicationContext) applicationContext)
                    .setServerNamespace("my-thymeleaf");
        }
    }
}