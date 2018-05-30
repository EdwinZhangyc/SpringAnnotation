package com.zyc.annotation.config;

import com.zyc.annotation.bean.Car;
import com.zyc.annotation.bean.Cat;
import com.zyc.annotation.bean.Dog;
import com.zyc.annotation.bean.MyBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Bean的声明周期，四種寫法
 */
@Configuration
public class MainConfigOfLiftCycle {

    @Bean(initMethod = "init", destroyMethod = "destory")
    public Car car(){
        return new Car();
    }

    @Bean
    public Cat cat(){
        return new Cat();
    }

    @Bean
    public Dog dog(){
        return  new Dog();
    }

    /**
     * 初始化前後進行執行
     * @return
     */
    @Bean
    public MyBeanPostProcessor myBeanPostProcessor(){
        return new MyBeanPostProcessor();
    }
}