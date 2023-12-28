package com.aries.redis.common;

public class Result {
    private Integer code;

    private String message;

    public Result() {
    }

    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public static Result success() {
        return new Result(200, "成功");
    }

    public static Result fail() {
        return new Result(400, "失败");
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
