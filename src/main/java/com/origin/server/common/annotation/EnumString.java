package com.origin.server.common.annotation;

import com.origin.server.common.config.EnumStringValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author qijs
 * @version 1.0
 * @description: 检验性别属性注解
 * @date 2021/11/11/0011 15:58
 */
@Target({ElementType.METHOD,ElementType.FIELD,ElementType.ANNOTATION_TYPE,ElementType.CONSTRUCTOR,ElementType.PARAMETER,ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = EnumStringValidator.class)
public @interface EnumString {
    String message() default "value not in enum values.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    /**
     * @return date must in this value array
     */
    String[] value();

    /**
     * Defines several {@link EnumString} annotations on the same element.
     *
     * @see EnumString
     */
    @Target({ElementType.METHOD,ElementType.FIELD,ElementType.ANNOTATION_TYPE,ElementType.CONSTRUCTOR,ElementType.PARAMETER,ElementType.TYPE_USE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List {
        EnumString[] value();
    }
}
