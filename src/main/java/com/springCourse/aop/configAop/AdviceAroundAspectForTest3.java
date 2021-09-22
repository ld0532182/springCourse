package com.springCourse.aop.configAop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AdviceAroundAspectForTest3 {

    @Around("execution(String returnBook())")
    public Object aroundReturnBookAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("aroundReturnBookAdvice в библиотеку пытаются вернуть книгу");

        long begin = System.currentTimeMillis();
        Object targetMethodResult = null;
        //можно поменять возвращаемое значение
        targetMethodResult = "fakeBook";
        //В Around можно обрабатывать исключения
        try {
            targetMethodResult = proceedingJoinPoint.proceed();
        } catch (Exception e) {
            System.out.println("Было поймано исключение " + e);
            throw e;
        }

        long end = System.currentTimeMillis();

        System.out.println("aroundReturnBookAdvice: метод uniLibrary.returnBook() " +
                "выполнил работу за " + (end - begin) + "mls");

        System.out.println("aroundReturnBookAdvice в библиотеку успешно возвращают книгу");
        return targetMethodResult;
    }


}
