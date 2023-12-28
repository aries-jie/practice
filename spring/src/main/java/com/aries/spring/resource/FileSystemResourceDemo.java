package com.aries.spring.resource;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import java.io.InputStream;

public class FileSystemResourceDemo {
    public static void main(String[] args) throws Exception {
        // 请替换我们自己的目录
        String path = "D:\\gitcode\\practice\\spring\\src\\main\\resources\\application.properties";
        Resource resource = new FileSystemResource(path);
        try (InputStream is = resource.getInputStream()) {
            // 读取和处理资源内容
            System.out.println(new String(is.readAllBytes()));
        }
    }
}