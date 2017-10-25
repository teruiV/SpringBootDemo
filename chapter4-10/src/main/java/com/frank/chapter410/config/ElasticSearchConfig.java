package com.frank.chapter410.config;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author jianweilin
 * @date 2017/10/24
 */
@Configuration
@EnableElasticsearchRepositories(basePackages = "com.frank.chapter410.repository")
public class ElasticSearchConfig {
    @Value("${elasticsearch.host}")
    private String esHost;

    @Value("${elasticsearch.port}")
    private int esPort;

    @Value("${elasticsearch.clustername}")
    private String esClusterName;


    @Bean
    public Client client() throws UnknownHostException {
        Settings esSettings = Settings.settingsBuilder()
                .put("cluster.name", esClusterName)
                .build();
        System.out.println("esHost = " + esHost + " esPort = " + esPort + " esClusterName = " + esClusterName );

        return TransportClient.builder().settings(esSettings).build()
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(esHost),esPort));
    }

    @Bean
    public ElasticsearchOperations elasticsearchOperations() throws UnknownHostException {
        return new ElasticsearchTemplate(client());
    }
}
