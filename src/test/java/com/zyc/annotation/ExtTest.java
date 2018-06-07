package com.zyc.annotation;

import com.zyc.annotation.config.MainConfigOfExtends;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ExtTest {

    @Test
    public void test(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfExtends.class);

    }
}