package com.aries.spring.config;

import com.aries.spring.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {
    @Bean()
    public User user() {
        return new User("aries", 31);
    }
}