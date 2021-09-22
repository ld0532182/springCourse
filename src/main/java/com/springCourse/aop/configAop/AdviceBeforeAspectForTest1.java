package com.springCourse.aop.configAop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(10)
public class AdviceBeforeAspectForTest1 {

    /** Три обязательных типа данных в Advice: возвращаемый тип, имя метода, параметры*/

    //Advice для конкретного метода
    @Before("execution(public void com.springCourse.aop.supportClasses.UniLibrary.getBook())")
    public void beforeGetBookAdvice(){
        System.out.println("beforeGetBookAdvice: Попытка получить книгу");
    }

    /**Advice для методов с параметром. Для методов с любым кол-вом любых параметров
       сделана следующая конструкция: execution(void getBook(..))
    */
    @Before("execution(void getBook(String))")
    public void beforeGetBookWithName(){
        System.out.println("beforeGetBookWithName: берем конкретную книгу");
    }

    //любое название после get
    @Before("execution(void get*())")
    public void beforeGetAnything(){
        System.out.println("beforeGetAnything: берем что-то");
    }
    //любой возвращаемый тип
    @Before("execution(* returnBook())")
    public void beforeReturnBook(){
        System.out.println("beforeReturnBook: попытка вернуть книгу");
    }

}
