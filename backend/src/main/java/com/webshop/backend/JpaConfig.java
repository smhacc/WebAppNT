package com.webshop.backend;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class JpaConfig {

    @Bean
    public DataSource getDataSource()
    {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("oracle.jdbc.driver.OracleDriver");
        dataSourceBuilder.url("jdbc:oracle:thin:@localhost:1521:xe");
        dataSourceBuilder.username("C##WEBAPPNT");
        dataSourceBuilder.password("12345678");
        return dataSourceBuilder.build();
    }
}