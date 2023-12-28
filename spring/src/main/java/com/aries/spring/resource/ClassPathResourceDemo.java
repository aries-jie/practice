package com.aries.spring.resource;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.InputStream;

/**
 * ClassPathResource 用于访问类路径上的资源
 */
public class ClassPathResourceDemo {
    public static void main(String[] args) throws Exception {
        String path = "application.properties";
        Resource resource = new ClassPathResource(path);
        try (InputStream is = resource.getInputStream()) {
            // 读取和处理资源内容
            System.out.println(new String(is.readAllBytes()));
        }
    }
}