package com.origin.server.common.exception;

/**
 * @author qijs
 * @version 1.0.0
 * @Description 统一异常管理
 * @createTime 2020年12月20日 20:35:00
 */
public enum ExceptionEnum {
    /**
     * 成功
     */
    SUCCESS("200", "success"),
    UNKNOW_ERROR("500", "未知异常，请联系系统管理员！");

    private String code;

    private String info;

    ExceptionEnum(String code, String info) {
        this.code = code;
        this.info = info;
    }

    public String getCode() {
        return code;
    }

    public String getInfo() {
        return info;
    }
}
