package com.zyc.annotation.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Dog {

    public Dog(){
        System.out.println("create dog");
    }

    @PostConstruct
    public void init(){
        System.out.println("dog init");
    }

    @PreDestroy
    public void destory(){
        System.out.println("dog destory");
    }
}