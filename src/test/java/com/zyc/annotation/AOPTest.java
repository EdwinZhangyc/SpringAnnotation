package com.zyc.annotation;

import com.zyc.annotation.aop.MathTest;
import com.zyc.annotation.config.MainConfigOfAOP;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AOPTest {

    @Test
    public void test(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAOP.class);

        MathTest mathTest = applicationContext.getBean(MathTest.class);
        int  a = mathTest.div(4, 2);
    }
}