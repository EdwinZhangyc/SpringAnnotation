package com.zyc.annotation.spring.config;

import com.zyc.annotation.spring.bean.Person;
import com.zyc.annotation.spring.condition.LinuxCondition;
import com.zyc.annotation.spring.condition.WindowsCondition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * 需要实现的功能为：
 *                  当环境为windows环境时初始化person01
 *                  当环境为linux系统时初始化person02
 */
@Configuration
public class MainConfigOfConditional {

    /**
     * @Conditional({condition}): 按照一定条件进行初始化bean，spring底层大量使用，可以使用在类与方法上
     * 需要在@Conditional()注解中添加Condition的类（实现condition）
     */
    @Conditional(WindowsCondition.class)
    @Bean
    public Person person01(){
        return new Person("Bill Gates", 62);
    }

    @Conditional(LinuxCondition.class)
    @Bean
    public Person person02(){
        return new Person("linus", 48);
    }
}