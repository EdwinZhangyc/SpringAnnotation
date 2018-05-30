package com.zyc.annotation.config;

import com.zyc.annotation.bean.Blue;
import com.zyc.annotation.bean.MyFactoryBean;
import com.zyc.annotation.bean.Person;
import com.zyc.annotation.condition.MyImportBeanDefinitionRegister;
import com.zyc.annotation.condition.MyImportSelector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.inject.Inject;

/**
 * 本类写名将组件注入容器的几种的方式
 */
@Configuration
//1、使用自动扫描，扫描带有（@Controller，@Service，@Repository，@Component） 局限于自己写的组件
@ComponentScan
//3、使用import注解的三種方式
@Import({Person.class, MyImportSelector.class, MyImportBeanDefinitionRegister.class})
/**
 * @Import（快速的给容器导入一个组件）如注释中所示import一共可以使用三种方式进行导入组件
 * 1）@Import（要导入到容器中的组件）直接导入组件的方式，容器中就会自动注册这个组件，id默认是全类名。同时可以直接导入其他配置类
 * 2）实现ImportSelector接口（导入选择器）返回需要导入的组件的全类名数组，其中参数说明AnnotationMetadata为使用@Import的配置类中的所有注解详细信息
 * @Import({ImportSelector.class}) ImportSelector返回类全名称的一个数组，配置类将数组中的所有类注册到容器中
 * 3）ImportBeanDefinitionRegister接口：手工导入所要导入的组件  可以添加一些条件进行
 */
public class MainConfigOfRegisterBean {

    //2 使用@Bean的方式注入組件
    @Bean
    public Blue blue(){
        return new Blue();
    }

    //4 使用實現FactoryBean接口的方式，在注入到容器中
    @Bean
    public MyFactoryBean myFactoryBean(){
        return new MyFactoryBean();
    }


}