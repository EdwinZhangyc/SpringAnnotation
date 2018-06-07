package com.zyc.annotation;

import com.zyc.annotation.config.MainConfigOfTx;
import com.zyc.annotation.tx.UserController;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TxTest {

    @Test
    public void test(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfTx.class);
        UserController bean = applicationContext.getBean(UserController.class);
        //UserServiceImpl bean = applicationContext.getBean(UserServiceImpl.class);
        bean.insertUser();
    }
}