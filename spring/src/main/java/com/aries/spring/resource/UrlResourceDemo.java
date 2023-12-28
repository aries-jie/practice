package com.aries.spring.resource;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import java.io.InputStream;

public class UrlResourceDemo {
    public static void main(String[] args) throws Exception {
        Resource resource = new UrlResource("https://dist.apache.org/repos/dist/test/test.txt");
        try (InputStream is = resource.getInputStream()) {
            // 读取和处理资源内容
            System.out.println(new String(is.readAllBytes()));
        }
    }
}