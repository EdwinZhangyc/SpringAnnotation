package com.zyc.annotation.spring.ext;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

//添加到IOC容器
@Component
public class UseAnnotationEventListener {

    @EventListener(value = {ApplicationEvent.class})
    public void listenerTest(ApplicationEvent event){
        System.out.println("UseAnnotationEventListener  receive event: "+ event);
    }
}