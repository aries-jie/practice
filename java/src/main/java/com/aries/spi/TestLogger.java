package com.aries.spi;

public class TestLogger {
    public static void main(String[] args) {
        LoggerService service = LoggerService.getService();

        service.info("Hello SPI");
    }
}
