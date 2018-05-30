package com.zyc.annotation.config;

import com.zyc.annotation.bean.Plane;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MainConfigOfAutowired {

    @Bean
    public Plane plane(){
        return new Plane();
    }
}