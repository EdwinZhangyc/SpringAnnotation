package com.zyc.annotation.config;

import com.zyc.annotation.aop.LogAspectJ;
import com.zyc.annotation.aop.MathTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

//开启注解式切面
@EnableAspectJAutoProxy
@Configuration
public class MainConfigOfAOP {

    @Bean
    public MathTest math(){
        return new MathTest();
    }

    @Bean
    public LogAspectJ logAspectJ(){
        return new LogAspectJ();
    }
}