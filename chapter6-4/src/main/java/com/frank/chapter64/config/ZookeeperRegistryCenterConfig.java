package com.frank.chapter64.config;

import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperConfiguration;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author jianweilin
 * @date 2017/10/31
 */
@Configuration
@ConditionalOnExpression("'${regCenter.serverList}'.length()>0")
public class ZookeeperRegistryCenterConfig {
    @Bean(initMethod = "init")
    public ZookeeperRegistryCenter regCenter(@Value("${regCenter.serverList}") final String serverList,
                                             @Value("${regCenter.namespace}") final String namespace){
        return new ZookeeperRegistryCenter(new ZookeeperConfiguration(serverList,namespace));
    }
}
