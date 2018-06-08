package com.zyc.annotation.ext;

import com.zyc.annotation.bean.Car;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.*;
import org.springframework.stereotype.Component;

@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
    /**
     * BeanDefinitionRegistry bean定義信息的保存中心，
     * 以後BeanFactory就是按照BeanDefinitionRegistry裏面保存的每一個bean定義信息，創建bean實例
     * @param registry bean定義信息的保存中心
     * @throws BeansException
     */
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        System.out.println("BeanDefinitionRegistryPostProcessor.postProcessBeanDefinitionRegistry bean count: " + registry.getBeanDefinitionCount());
        RootBeanDefinition beanDefinition = new RootBeanDefinition(Car.class);
        AbstractBeanDefinition beanDefinition1 = BeanDefinitionBuilder.rootBeanDefinition(Car.class).getBeanDefinition();
        registry.registerBeanDefinition("aa",beanDefinition);
        registry.registerBeanDefinition("bb",beanDefinition1);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("BeanDefinitionRegistryPostProcessor.postProcessBeanFactory bean count: " + beanFactory.getBeanDefinitionCount());
    }
}