package com.frank.chapter412.config;

import org.jooq.*;
import org.jooq.conf.Settings;
import org.jooq.impl.DataSourceConnectionProvider;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.jooq.impl.DefaultExecuteListenerProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class JOOQConfig {

    @Configuration
    public static class DslContextConfig {

        @Autowired(required = false)
        private RecordMapperProvider recordMapperProvider;

        @Autowired(required = false)
        private Settings settings;

        @Autowired(required = false)
        private RecordListenerProvider[] recordListenerProviders;


        @Autowired(required = false)
        private VisitListenerProvider[] visitListenerProviders;

        @Bean
        @Primary
        public DefaultDSLContext dslContextBdUseReadDb(@Qualifier(value = "dataSourceConnectionProviderBdUseReadDb") DataSourceConnectionProvider connectionProviderBdUseReadDb) {
            return new DefaultDSLContext(configuration(connectionProviderBdUseReadDb, null));
        }

        @Bean
        public DefaultDSLContext dslContextBdUseWriteDb(@Qualifier(value = "dataSourceConnectionProviderBdUseWriteDb") DataSourceConnectionProvider connectionProviderBdUseWriteDb,
                                                        @Qualifier(value = "transactionProviderBdUseWriteDb") TransactionProvider transactionProviderBdUseWriteDb) {
            return new DefaultDSLContext(configuration(connectionProviderBdUseWriteDb, transactionProviderBdUseWriteDb));
        }

        @Bean
        @Primary
        public DefaultDSLContext dslContextDadaReadDb(@Qualifier(value = "dataSourceConnectionProviderDadaReadDb") DataSourceConnectionProvider connectionProviderReadDb) {
            return new DefaultDSLContext(configuration(connectionProviderReadDb, null));
        }

        @Bean
        public DefaultDSLContext dslContextDadaWriteDb(@Qualifier(value = "dataSourceConnectionProviderDadaWriteDb") DataSourceConnectionProvider connectionProviderWriteDb,
                                                        @Qualifier(value = "transactionProviderDadaWriteDb") TransactionProvider transactionProviderWriteDb) {
            return new DefaultDSLContext(configuration(connectionProviderWriteDb, transactionProviderWriteDb));
        }


        private DefaultConfiguration configuration(ConnectionProvider connectionProvider, TransactionProvider transactionProvider) {
            DefaultConfiguration configuration = new DefaultConfiguration();
            configuration.setSQLDialect(SQLDialect.MYSQL);
            configuration.set(connectionProvider);
            if (transactionProvider != null) {
                configuration.set(transactionProvider);
            }
            if (this.recordMapperProvider != null) {
                configuration.set(this.recordMapperProvider);
            }
            if (this.settings != null) {
                configuration.set(this.settings);
            }
            configuration.set(this.recordListenerProviders);
            configuration.set(this.visitListenerProviders);
            return configuration;
        }
    }
}