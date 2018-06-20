package com.zyc.annotation.spring;

import com.zyc.annotation.spring.bean.Person;
import com.zyc.annotation.spring.config.MainConfigOfComponnetScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {

    public static void main (String[] args){

        //配置文件的方式
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:beans.xml");
        Person person = (Person) applicationContext.getBean("person");
        System.out.print(person);
        //配置类的方式注入bean
        ApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfigOfComponnetScan.class);
        Person person1 = (Person)annotationConfigApplicationContext.getBean("person1");
        Person person2 = annotationConfigApplicationContext.getBean(Person.class);
        System.out.println(person1);
        System.out.println(person2);
        //打印bean名称
        String[] beanNamesForType = annotationConfigApplicationContext.getBeanNamesForType(Person.class);
        for (String b: beanNamesForType
             ) {
            System.out.println(b);
        }


    }
}