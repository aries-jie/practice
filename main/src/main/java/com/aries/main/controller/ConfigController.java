package com.aries.main.controller;

import com.aries.main.config.Aries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {

    /**
     * 如果 application.properties 和 application.yml 都配置的话，最终读取的是 application.properties 的值
     */
    @Autowired
    private Aries aries;

    @GetMapping("/getAries")
    public Aries getAries() {
        return aries;
    }

}
