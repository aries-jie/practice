package com.aries.spi;

public class Logback implements Logger {
    @Override
    public void info(String msg) {
        System.out.println("logback:" + msg);
    }
}
