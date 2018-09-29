package com.william.chapter71.autoconfigure;

import com.william.chapter71.domain.Greeter;
import com.william.chapter71.domain.GreeterConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.william.chapter71.domain.Greeter.MORNING_MSG;
import static com.william.chapter71.domain.Greeter.*;

/**
 * @author jianweilin
 * @date 2018/9/29
 */
@Configuration
@ConditionalOnClass(Greeter.class)
@EnableConfigurationProperties({GreeterProperties.class})
public class GreeterAutoConfiguration {

    @Autowired
    private GreeterProperties greeterProperties;

    @Bean
    @ConditionalOnMissingBean
    public GreeterConfig greeterConfig() {
        String userName = greeterProperties.getUserName() == null ? "admin" : greeterProperties.getUserName();
        String morningMsg = greeterProperties.getMorningMsg() == null ? "Good Morning" : greeterProperties.getMorningMsg();
        String afternoonMessage = greeterProperties.getAfternoonMsg() == null ? "Good Afternoon" : greeterProperties.getAfternoonMsg();
        String eveningMessage = greeterProperties.getEveningMsg() == null ? "Good Evening" : greeterProperties.getEveningMsg();
        String nightMessage = greeterProperties.getNightMsg() == null ? "Good Night" : greeterProperties.getNightMsg();

        GreeterConfig greeterConfig = new GreeterConfig();
        greeterConfig.put(USER_NAME,userName);
        greeterConfig.put(MORNING_MSG,morningMsg);
        greeterConfig.put(AFTERNOON_MSG,afternoonMessage);
        greeterConfig.put(EVENING_MSG,eveningMessage);
        greeterConfig.put(NIGHT_MSG,nightMessage);

        return greeterConfig;
    }

    @Bean
    @ConditionalOnMissingBean
    public Greeter greeter(GreeterConfig greeterConfig){
        return new Greeter(greeterConfig);
    }
}
