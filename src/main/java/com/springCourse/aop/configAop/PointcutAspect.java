package com.springCourse.aop.configAop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(20)
public class PointcutAspect {

    @Pointcut("execution(void get*())")
    private void pointcutGet(){}

    @Pointcut("execution(void return*())")
    private void pointcutReturn(){}

    @Pointcut("pointcutGet() || pointcutReturn()")
    private void pointcutGetAndReturn(){}




    @Before("pointcutGet()")
    public void logging1(){
        System.out.println("logging1: #1 get");
    }

    @Before("pointcutReturn()")
    public void logging2(){
        System.out.println("logging2: #2 return");
    }

    @Before("pointcutGetAndReturn()")
    public void logging3(){
        System.out.println("logging3: #3 GetAndReturn");
    }
}
