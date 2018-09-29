package com.william.chapter71.autoconfigure;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author jianweilin
 * @date 2018/9/29
 */
@ConfigurationProperties(prefix = "com.william.greeter")
@Data
public class GreeterProperties {
    private String userName;
    private String morningMsg;
    private String afternoonMsg;
    private String eveningMsg;
    private String nightMsg;
}
