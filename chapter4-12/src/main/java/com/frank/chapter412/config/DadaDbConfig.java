package com.frank.chapter412.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.jooq.impl.DataSourceConnectionProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 *
 */
@Configuration
public class DadaDbConfig {

    // ---- 读库 ----
    @Bean
    @ConfigurationProperties(prefix = "db.dada.read")
    public DataSource dataSourceDadaReadDb() {
        return new DruidDataSource();
    }

    @Bean
    public DataSourceConnectionProvider dataSourceConnectionProviderDadaReadDb(
            @Qualifier("dataSourceDadaReadDb") DataSource dataSource) {
        return new DataSourceConnectionProvider(dataSource);
    }

    // ---- 写库 ----
    @Bean
    @ConfigurationProperties(prefix = "db.dada.write")
    public DataSource dataSourceDadaWriteDb() {
        return new DruidDataSource();
    }

    @Bean
    public DataSourceTransactionManager transactionManagerDadaWriteDb() {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSourceDadaWriteDb());
        return transactionManager;
    }

    @Bean
    public DataSourceConnectionProvider dataSourceConnectionProviderDadaWriteDb(
            @Qualifier("dataSourceDadaWriteDb") DataSource dataSource) {
        return new DataSourceConnectionProvider(dataSource);
    }

    @Bean
    public SpringTransactionProvider transactionProviderDadaWriteDb(
            @Qualifier("transactionManagerDadaWriteDb") DataSourceTransactionManager txManagerW) {
        return new SpringTransactionProvider(txManagerW);
    }
}
