package com.origin.server.common.exception;

/**
 * @author qijs
 * @version 1.0.0
 * @Description 异常处理
 * @createTime 2021年04月13日 11:36:00
 */
public class BootException extends RuntimeException {
    /**
     * 成功
     */

    private Integer code;

    private String info;

    public BootException(Integer code, String info) {
        this.code = code;
        this.info = info;
    }

    public Integer getCode() {
        return code;
    }

    public String getInfo() {
        return info;
    }
}
