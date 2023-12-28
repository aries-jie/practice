package com.aries.spring.bean;

import com.aries.spring.annotation.MyAnnotation;
import com.aries.spring.annotation.MyClassAnnotation;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@MyClassAnnotation
public final class MyBean extends MyAbstract implements Serializable {

    public String key;

    public String value;

    @MyAnnotation
    public static void myMethod1() {
        // 方法1的实现
    }

    @MyAnnotation
    public String myMethod2() {
        return "hello world";
    }

    public void myMethod3() {
        // 方法3的实现
    }

    public static class MyInnerClass {
        // 内部类的定义
    }
}