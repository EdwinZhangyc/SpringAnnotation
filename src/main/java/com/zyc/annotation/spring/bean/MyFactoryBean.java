package com.zyc.annotation.spring.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * 創建一個Spring定義的FactoryBean
 */
public class MyFactoryBean implements FactoryBean<MyBean> {

    //返回一個MyBean對象，這個對象會添加到容器中
    @Override
    public MyBean getObject() throws Exception {
        return new MyBean();
    }

    //定義類型
    @Override
    public Class<?> getObjectType() {
        return MyBean.class;
    }

    /**
     * 是否為單利模式
     * true：這個實例為單實例，在容器中保留一份
     * false:為多實例，每一次獲取都會產生一個新的bean
     */
    @Override
    public boolean isSingleton() {
        return false;
    }
}