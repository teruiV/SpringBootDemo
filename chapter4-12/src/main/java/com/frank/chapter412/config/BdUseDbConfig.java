package com.frank.chapter412.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.jooq.impl.DataSourceConnectionProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jooq.JooqAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * Created by HYL on 2016/10/16.
 */
@Configuration
public class BdUseDbConfig {

    // ---- 读库 ----
    @Bean
    @ConfigurationProperties(prefix = "db.bduse.read")
    @Primary
    public DataSource dataSourceBdUseReadDb() {
        return new DruidDataSource();
    }

    @Bean
    @Primary
    public DataSourceConnectionProvider dataSourceConnectionProviderBdUseReadDb(
            @Qualifier("dataSourceBdUseReadDb") DataSource dataSource) {
        return new DataSourceConnectionProvider(dataSource);
    }

    // ---- 写库 ----
    @Bean
    @ConfigurationProperties(prefix = "db.bduse.write")
    public DataSource dataSourceBdUseWriteDb() {
        return new DruidDataSource();
    }

    @Bean
    public DataSourceTransactionManager transactionManagerBdUseWriteDb() {
        JooqAutoConfiguration s;
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSourceBdUseWriteDb());
        return transactionManager;
    }
    @Bean
    public DataSourceTransactionManager txManager() {
        return transactionManagerBdUseWriteDb();
    }
    @Bean
    @Primary
    public DataSourceConnectionProvider dataSourceConnectionProviderBdUseWriteDb(
            @Qualifier("dataSourceBdUseWriteDb") DataSource dataSource) {
        return new DataSourceConnectionProvider(dataSource);
    }

    @Bean
    @Primary
    public SpringTransactionProvider transactionProviderBdUseWriteDb(
            @Qualifier("transactionManagerBdUseWriteDb") DataSourceTransactionManager txManagerW) {
        return new SpringTransactionProvider(txManagerW);
    }

}
