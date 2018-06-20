package com.zyc.annotation.spring.config;

import com.zyc.annotation.spring.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

@Configuration
public class MainConfigOfScope {

    /**
     * 默认bean都是单实例的，可以使用@Scope注解进行设置,可以放在类上或是放在方法上进行使用
     * prototype  多实例  如果是多实例的时候，bean在每一次获取时进行初始化
     * singleton  单实例（默认） 如果是单实例的时候，bean在IOC容器创建时进行初始化，以后每一次请求直接从容器中进行（getBean）
     * request    同一次请求创建一个实例
     * session    同一个session创建一个实例
     */
    @Lazy//懒加载与单实例对象相配合，当第一次调用的时候才进行加载
    @Scope
    //@Scope("prototype")
    @Bean
    public Person person(){
        return new Person("zhangsan", 18);
    }
}