package com.example.demo.config;

import com.example.demo.db.MySqlHelper;
import com.zaxxer.hikari.HikariConfig;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.mysql") // application.properteis中对应属性的前缀
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean("secondDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.mysql2") // application.properteis中对应属性的前缀
    public DataSource dataSource2() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @Primary
    public MySqlHelper primarySqlHelper(DataSource dataSource){
        return new MySqlHelper(dataSource);
    }

    @Bean(name = "transactionManager")
    @Primary
    public DataSourceTransactionManager getDataSourceTransactionManager(@Qualifier("dataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "secondTransactionManager")
    @Primary
    public DataSourceTransactionManager getDataSourceTransactionManager2(@Qualifier("secondDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    /*
    @Bean
@Primary
public JdbcTemplate primaryJdbcTemplate(DataSource dataSource) {
    return new JdbcTemplate(dataSource);
}

@Bean(name = "secondJdbcTemplate")
public JdbcTemplate secondJdbcTemplate(@Qualifier("secondDatasource") DataSource dataSource) {
    return new JdbcTemplate(dataSource);
}
    * */

    //https://www.liaoxuefeng.com/article/1127277451217344
}
