package com.aries.spring.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@ToString
@AllArgsConstructor
@Data
public class User {
    private String name;
    private Integer age;
}