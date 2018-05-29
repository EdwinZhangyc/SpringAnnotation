package com.zyc.annotation.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Cat implements InitializingBean, DisposableBean{

    public Cat(){
        System.out.println("create cat");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destory cat");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet cat");
    }
}