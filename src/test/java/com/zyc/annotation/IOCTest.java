package com.zyc.annotation;

import com.zyc.annotation.bean.Person;
import com.zyc.annotation.config.MainConfig;
import com.zyc.annotation.config.MainConfigOfConditional;
import com.zyc.annotation.config.MainConfigOfImport;
import com.zyc.annotation.config.MainConfigOfLiftCycle;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

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


    @Test
    public void Test02 (){

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfConditional.class);
        Environment environment = applicationContext.getEnvironment();
        //获取操作系统的名称
        String property = environment.getProperty("os.name");
        System.out.println(property);
        String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);
        for (String s :
                beanNamesForType) {
            System.out.print(s);
        }
    }

    @Test
    public void Test03() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfImport.class);
        String[] beanNamesForType = applicationContext.getBeanDefinitionNames();
        for (String s :
                beanNamesForType) {
            System.out.println(s);
        }
    }

    @Test
    public void Test04(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfLiftCycle.class);
        applicationContext.close();
    }
}