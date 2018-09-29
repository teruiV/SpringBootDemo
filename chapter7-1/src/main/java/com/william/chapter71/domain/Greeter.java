package com.william.chapter71.domain;

import java.time.LocalDateTime;

/**
 * @author jianweilin
 * @date 2018/9/29
 */
public class Greeter {
    public static final String USER_NAME = "user.name";
    public static final String MORNING_MSG = "morning.msg";
    public static final String AFTERNOON_MSG = "afternoon.msg";
    public static final String EVENING_MSG = "evening.msg";
    public static final String NIGHT_MSG = "night.msg";

    private GreeterConfig greeterConfig;

    public Greeter(GreeterConfig greeterConfig) {
        this.greeterConfig = greeterConfig;
    }

    public String greet(LocalDateTime localDateTime) {
        String name = greeterConfig.getProperty(USER_NAME);
        int hourOfDay = localDateTime.getHour();

        if (hourOfDay >= 5 && hourOfDay < 12) {
            return String.format("Hello %s, %s", name, greeterConfig.get(MORNING_MSG));
        } else if (hourOfDay >= 12 && hourOfDay < 17) {
            return String.format("Hello %s, %s", name, greeterConfig.get(AFTERNOON_MSG));
        } else if (hourOfDay >= 17 && hourOfDay < 20) {
            return String.format("Hello %s, %s", name, greeterConfig.get(EVENING_MSG));
        } else {
            return String.format("Hello %s, %s", name, greeterConfig.get(NIGHT_MSG));
        }
    }

    public String greet(){
        return greet(LocalDateTime.now());
    }
}
