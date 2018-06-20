package com.zyc.annotation.spring.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * 使用了几種得到環境變量中值的方式
 */
@PropertySource("classpath:dbconfig.properties")
@Configuration
public class MainConfigOfProfile implements EmbeddedValueResolverAware {

    @Value("${db.user}")
    private String user;
    private String driverClass;
    @Value("jdbc:mysql://192.168.92.100:3306/dbbase")
    private String address;

    @Profile("test")
    @Bean
    public DataSource testDataSource(@Value("${db.pass}")String pass) throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(pass);
        dataSource.setDriverClass(driverClass);
        dataSource.setJdbcUrl(address);
        return dataSource;
    }
    @Profile("dev")
    @Bean
    public DataSource devDataSource(@Value("${db.pass}")String pass) throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(pass);
        dataSource.setDriverClass(driverClass);
        dataSource.setJdbcUrl(address);
        return dataSource;
    }

    @Profile("prov")
    @Bean
    public DataSource provDataSource(@Value("${db.pass}")String pass) throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(pass);
        dataSource.setDriverClass(driverClass);
        dataSource.setJdbcUrl(address);
        return dataSource;
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        this.driverClass = resolver.resolveStringValue("${db.driver}");
    }
}