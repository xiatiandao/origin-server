package com.origin.server.common.aop.aspect;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.origin.server.common.annotation.AutoLog;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * @author qijs
 * @version 1.0.0
 * @Description 日志切面
 * @createTime 2020年12月18日 15:56:00
 */
@Aspect
@Slf4j
@Component
public class LogAspect {

    /**
     * 定义切点Pointcut
     * 第一个*号：表示返回类型， *号表示所有的类型
     * 第二个*号：表示类名，*号表示所有的类
     * 第三个*号：表示方法名，*号表示所有的方法
     * 后面括弧里面表示方法的参数，两个句点表示任何参数
     */
    @Pointcut("execution(* com.origin.server.controller..*.*(..))")
    public void logPointcut(){}

    @Around(value = "logPointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("============ start ============");
        long beginTime = System.currentTimeMillis();

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        Object result;
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();

        log.info("HTTP URL : " + request.getRequestURL().toString());
        log.info("HTTP METHOD : " + request.getMethod());
        log.info("CLASS METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "."
                + joinPoint.getSignature().getName());
        log.info("PARAMS : " + getRequestParams(request, joinPoint));

        //执行方法
        result = joinPoint.proceed();
        log.info("The response parameter is：{}", JSON.toJSONString(result));
        log.info("execution time：{}ms", System.currentTimeMillis() - beginTime);
        log.info("============= end =============");
        return result;
    }

    /**
     * 获取请求参数
     * @param request 请求对象
     * @param joinPoint 织入对象
     * @return
     */
    private String getRequestParams(HttpServletRequest request, ProceedingJoinPoint joinPoint) {
        String httpMethod = request.getMethod();
        StringBuilder params = new StringBuilder();
        boolean isStatus = "POST".equals(httpMethod) || "PUT".equals(httpMethod) || "PATCH".equals(httpMethod);
        if (isStatus){
            Object[] paramsArray = joinPoint.getArgs();
            params.append(JSONObject.toJSONString(paramsArray));
        }else {
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            Method method = signature.getMethod();
            // 请求的方法参数值
            Object[] args = joinPoint.getArgs();
            // 请求的方法参数名称
            LocalVariableTableParameterNameDiscoverer u = new LocalVariableTableParameterNameDiscoverer();
            String[] paramNames = u.getParameterNames(method);
            if (args != null && paramNames != null) {
                for (int i = 0; i < args.length; i++) {
                    params.append("(").append(paramNames[i]).append(":").append(args[i]).append(")");
                }
            }
        }
        return params.toString();
    }
}
