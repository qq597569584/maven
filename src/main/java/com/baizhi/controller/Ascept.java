package com.baizhi.controller;


import com.baizhi.service.Log;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

@Aspect
@Component
@Slf4j
public class Ascept {


    @Around("pt()")
    public Object testAround(ProceedingJoinPoint proceedingJoinPoint) {

        /*获取request对象*/
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes requestAttributes1 = (ServletRequestAttributes) requestAttributes;
        HttpServletRequest request = requestAttributes1.getRequest();
        Object adminname = request.getSession().getAttribute("fl");
        String s = adminname.toString();
        Date date = new Date();
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        Method method = signature.getMethod();
        method.getAnnotation(Log.class);
        Log annotation = method.getAnnotation(Log.class);
        String name = annotation.name();
        boolean flag = false;
        Object proceed = null;
        try {
            proceed = proceedingJoinPoint.proceed();
            flag = true;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        log.info("who:{}===what:{}===when:{}===result:{}", s, name,
                new SimpleDateFormat("yyyy-MM-dd").format(date), flag);
        return proceed;
    }

    @Pointcut("@annotation(com.baizhi.service.Log)")
    public void pt() {

    }
}
