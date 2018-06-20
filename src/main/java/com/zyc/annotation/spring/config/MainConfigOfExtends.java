package com.zyc.annotation.spring.config;

import com.zyc.annotation.spring.bean.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.zyc.annotation.ext")
public class MainConfigOfExtends {

    @Bean
    public Car car(){
        return new Car();
    }
}