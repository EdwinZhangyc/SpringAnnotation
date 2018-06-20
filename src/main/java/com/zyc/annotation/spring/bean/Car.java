package com.zyc.annotation.spring.bean;

public class Car {

    public Car(){
        System.out.println("create...car..");
    }

    public void init (){
        System.out.println("init...car...");
    }

    public void destory(){
        System.out.println("detorty...car...");
    }
}