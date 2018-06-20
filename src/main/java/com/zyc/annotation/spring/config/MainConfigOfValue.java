package com.zyc.annotation.spring.config;

import com.zyc.annotation.spring.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.Resource;

@Configuration
@PropertySource(encoding = "GBK",value = {"classpath:person.properties"})
public class MainConfigOfValue {

    @Resource()
    @Bean
    public Person person(){
        return new Person("zhang", 22);
    }
}