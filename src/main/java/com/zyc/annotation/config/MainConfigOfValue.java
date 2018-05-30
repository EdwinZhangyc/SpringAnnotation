package com.zyc.annotation.config;

import com.zyc.annotation.bean.Person;
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