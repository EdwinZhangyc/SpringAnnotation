package com.zyc.annotation.ext;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MyApplicationListener implements ApplicationListener<ApplicationEvent> {

    @EventListener
    //在事件發佈時觸發該方法
    @Override
    public void onApplicationEvent(ApplicationEvent event) {

        System.out.println("該事件為: " + event.toString());

    }
}