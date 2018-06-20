package com.zyc.annotation.spring.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * 基于注解的声明式事物
 * 首先搭建环境：
 *  1、导入相关依赖
 *      数据源、数据库驱动、spring-jdbc模块
 *  2、配置数据源，JdbcTemplate（Spring提供简化数据库操作工具）操作数据
 *  3、给方法上添加@Transactional 表示当前方法是一个事务方法
 *  4、@EnableTransactionManagement 开启注解式事务
 *  5、配置事物管理器来控制事务
 *      public PlatformTransactionManager transactionManager() throws Exception {
            return new DataSourceTransactionManager(dataSource());
        }
 */

@Configuration
@ComponentScan("com.zyc.annotation.tx")
@EnableTransactionManagement//开启事物
public class MainConfigOfTx {

    //注册事物管理在容器中，   很重要
    @Bean
    public PlatformTransactionManager transactionManager() throws Exception {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    public DataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("root");
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://192.168.92.100:3306/test");
        return dataSource;
    }


    @Bean
    public JdbcTemplate jdbcTemplate() throws PropertyVetoException {
        //spring 对@Configuration类进行特殊处理，给容器组件中加组件方法，多次调用只是从容器中找组件，不会新创建组件
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
        return jdbcTemplate;
    }
}