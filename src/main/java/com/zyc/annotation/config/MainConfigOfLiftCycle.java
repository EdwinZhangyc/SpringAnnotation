package com.zyc.annotation.config;

import com.zyc.annotation.bean.Car;
import com.zyc.annotation.bean.Cat;
import com.zyc.annotation.bean.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
}