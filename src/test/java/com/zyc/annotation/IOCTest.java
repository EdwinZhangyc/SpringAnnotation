package com.zyc.annotation;

import com.zyc.annotation.config.MainConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest {

    @SuppressWarnings("resource")
    @Test
    public void testBeanNames(){

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        //打印所有bean名称
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String s: beanDefinitionNames
             ) {
            System.out.println(s);
        }
    }
}