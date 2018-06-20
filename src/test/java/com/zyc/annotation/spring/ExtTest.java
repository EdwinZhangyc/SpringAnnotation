package com.zyc.annotation.spring;

import com.zyc.annotation.spring.config.MainConfigOfExtends;
import org.junit.Test;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ExtTest {

    @Test
    public void test(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfExtends.class);
        //發佈一個事件
        applicationContext.publishEvent(new ApplicationEvent(new String("發佈一個事件")) {});
        applicationContext.close();
    }
}