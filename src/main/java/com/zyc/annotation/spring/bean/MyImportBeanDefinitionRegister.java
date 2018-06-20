package com.zyc.annotation.spring.bean;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegister implements ImportBeanDefinitionRegistrar {

    /**
     * @param importingClassMetadata:当前类的注解信息
     * @param registry：BeanDefinition注册类
     *                把所有需要添加到容器中的bean调用BeanDefinitionRegistry.registerBeanDefinition手工注册进来
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

        //首先判断两个bean是否存在
        boolean b = registry.containsBeanDefinition("Person");
        boolean c = registry.containsBeanDefinition("Color");
        if(b && c){
            //指定bean的定义信息，Bean的类型
            RootBeanDefinition beanDefinition = new RootBeanDefinition(Red.class);
            //注册一个Bean，指定Bean的名称
            registry.registerBeanDefinition("red", beanDefinition);
        }
    }
}