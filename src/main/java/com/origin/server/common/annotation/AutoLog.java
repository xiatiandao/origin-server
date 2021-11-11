package com.origin.server.common.annotation;

import java.lang.annotation.*;

/**
 * @author qijs
 * @version 1.0.0
 * @Description 自定义日志输出注解
 * @createTime 2020年12月20日 17:55:00
 */
@Target({ElementType.PARAMETER,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AutoLog {
    /**
     * 模块名
     */
    String name();

    /**
     * 描述
     */
    String value();
}
