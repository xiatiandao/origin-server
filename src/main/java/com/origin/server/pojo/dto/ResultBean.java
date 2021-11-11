package com.origin.server.pojo.dto;

import com.origin.server.common.enums.ReturnCode;
import com.origin.server.common.exception.BootException;
import com.origin.server.common.exception.ExceptionEnum;
import lombok.Data;

/**
 * @author qijs
 * @version 1.0.0
 * @Description 公共返回对象
 * @createTime 2020年12月20日 20:31:00
 */
@Data
public class ResultBean<T> {

    private Integer code;


    private String message;


    private T data;

    public ResultBean() {
    }

    public static <T> ResultBean<T> ok() {
        return new ResultBean<>(ReturnCode.RC200.getCode(),ReturnCode.RC200.getMessage());
    }

    public static <T> ResultBean<T> ok(String msg) {
        return new ResultBean<>(ReturnCode.RC200.getCode(), msg);
    }

    public static <T> ResultBean<T> success(T data) {
        ResultBean<T> resultBean = new ResultBean<>();
        resultBean.setCode(ReturnCode.RC200.getCode());
        resultBean.setMessage(ReturnCode.RC200.getMessage());
        resultBean.setData(data);
        return resultBean;
    }

    public static <T> ResultBean<T> error(Integer code, String message) {
        return new ResultBean<>(code, message);
    }

    public static <T> ResultBean<T> error(BootException bootException) {
        return new ResultBean<>(bootException.getCode(), bootException.getInfo());
    }



    private ResultBean(Integer code, String message) {
        super();
        this.code = code;
        this.message = message;
    }
}
