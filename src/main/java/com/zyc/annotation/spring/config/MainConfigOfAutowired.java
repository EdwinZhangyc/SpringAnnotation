package com.zyc.annotation.spring.config;

import com.zyc.annotation.spring.bean.Plane;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MainConfigOfAutowired {

    @Bean
    public Plane plane(){
        return new Plane();
    }
}