package com.origin.server.common.config;

import com.origin.server.common.annotation.EnumString;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

/**
 * @author qijs
 * @version 1.0
 * @description: 性别属性校验逻辑
 * @date 2021/11/11/0011 16:01
 */
public class EnumStringValidator implements ConstraintValidator<EnumString,String> {
    private List<String> enumStringList;

    @Override
    public void initialize(EnumString constraintAnnotation) {
        enumStringList = Arrays.asList(constraintAnnotation.value());
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if(value == null){
            return true;
        }
        return enumStringList.contains(value);
    }
}
