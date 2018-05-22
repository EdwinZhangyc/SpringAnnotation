package com.zyc.annotation.config;

import com.zyc.annotation.bean.Person;
import com.zyc.annotation.service.BookService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

//配置类等同于配置文件xml
@Configuration //告诉spring这是一个配置类
//@ComponentScan(value = "com.zyc.annotation") //启动包自动扫描功能
@ComponentScan(value = "com.zyc.annotation",
        //使用excludeFilters=Filter[]：指定扫描的时候按照什么规则排除那些组件
        //使用includeFileter=Filter[]: 指定扫描的时候按照什么规则只扫描哪些组件，与useDefaultFilters=false配合使用
        //excludeFilters={
        //@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class, Service.class})
        //}
        includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class}),
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = {BookService.class}),//FilterType.ASSIGNABLE_TYPE按照指定的类型进行匹配
        @ComponentScan.Filter(type = FilterType.CUSTOM,classes = {MyTypeFilter.class})//自定义过滤类，需要实现TypeFilter接口
        },useDefaultFilters = false
        )
//JDK1.8以后可以使用重复@ComponnetScan
//JDK1.8以前可以使用@ComponentScans(value={@ComponnetScan("com"),@ComponentScan("yan")})注解来抒写多个@ComponentScan注解

//FilterType.ANNOTATION:按照注解
//FilterType.ASSIGNABLE_TYPE：按照给的类型
//FilterType.ASPECTJ：使用AspectJ表达式
//FilterType.REGEX：使用正则表达式
//FilterType.CUSTOM：使用自定义表达式  （很重要）

public class MainConfig {

    //给容器注册一个bean，id默认为方法名字
    @Bean
    public Person person1(){
        return new Person("lisi", 20);
    }
}