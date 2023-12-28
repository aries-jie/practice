package com.aries.spring;

import com.aries.spring.config.WebConfig;
import com.aries.spring.domain.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringDemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringDemoApplication.class, args);

        // 返回 IOC 容器，使用注解配置，传入配置类
        ApplicationContext context = new AnnotationConfigApplicationContext(WebConfig.class);
        User user = context.getBean(User.class);
        System.out.println(user);
    }

}
