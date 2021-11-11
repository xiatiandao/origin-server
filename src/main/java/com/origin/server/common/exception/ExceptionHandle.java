package com.origin.server.common.exception;

import com.origin.server.common.enums.ReturnCode;
import com.origin.server.pojo.dto.ResultBean;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author qijs
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年04月13日 11:38:00
 */
@Slf4j
@RestControllerAdvice
public class ExceptionHandle {

    /**
     * 默认全局异常处理。
     * @param e the e
     * @return ResultBean
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultBean<String> exception(Exception e) {
        log.error("全局异常信息 ex={}", e.getMessage(), e);
        return ResultBean.error(ReturnCode.RC500.getCode(),e.getMessage());
    }

    /**
     * 抓取自定义异常
     */
    @ExceptionHandler(BootException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultBean<String> exception(BootException e) {
        return ResultBean.error(e.getCode(),e.getMessage());
    }


    @ExceptionHandler(value = {BindException.class, ValidationException.class, MethodArgumentNotValidException.class})
    public ResponseEntity<ResultBean<String>> handleValidatedException(Exception e) {
        ResultBean<String> resp = null;

        if (e instanceof MethodArgumentNotValidException) {
            // BeanValidation exception
            MethodArgumentNotValidException ex = (MethodArgumentNotValidException) e;
            resp = ResultBean.error(HttpStatus.BAD_REQUEST.value(),
                    ex.getBindingResult().getAllErrors().stream()
                            .map(ObjectError::getDefaultMessage)
                            .collect(Collectors.joining("; "))
            );
        } else if (e instanceof ConstraintViolationException) {
            // BeanValidation GET simple param
            ConstraintViolationException ex = (ConstraintViolationException) e;
            resp = ResultBean.error(HttpStatus.BAD_REQUEST.value(),
                    ex.getConstraintViolations().stream()
                            .map(ConstraintViolation::getMessage)
                            .collect(Collectors.joining("; "))
            );
        } else if (e instanceof BindException) {
            // BeanValidation GET object param
            BindException ex = (BindException) e;
            resp = ResultBean.error(HttpStatus.BAD_REQUEST.value(),
                    ex.getAllErrors().stream()
                            .map(ObjectError::getDefaultMessage)
                            .collect(Collectors.joining("; "))
            );
        }

        log.error("参数校验异常:{}",resp.getMessage());
        return new ResponseEntity<>(resp,HttpStatus.BAD_REQUEST);
    }
}
