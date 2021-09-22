package com.springCourse.aop.configAop;

import com.springCourse.aop.supportClasses.Student;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
public class AdviceAfterAspectForTest2 {

    @Before("execution(* getStudents(..))")
    public void beforeGetStudentsLog(){
        System.out.println("beforeGetStudentsLog: лог получения списка студентов до.");
    }


    //Изменение возвращаемого значения с помощью AfterReturning
    @AfterReturning(pointcut = "execution(* getStudents(..))", returning = "students")
    public void afterReturningStudentsLog(List<Student> students){

        Student st1 = students.get(0);
        String name  = st1.getNameSurname();
        name = "Mr. " + name;
        st1.setNameSurname(name);

        double avgGrade = st1.getAvgGrade();
        avgGrade = avgGrade+1;
        st1.setAvgGrade(avgGrade);

        System.out.println("afterReturningStudentsLog: лог получения списка студентов после.");
    }

    //Здесь обрабатывать исключения нельзя
    @AfterThrowing(pointcut = "execution(* getStudents(..))", throwing = "exception")
    public void afterThrowingStudentsLog(Throwable exception){

                System.out.println("afterThrowingStudentsLog: обнаружена ошибка " + exception);
    }

    @After("execution(* getStudents(..))")
    public void afterReturnOrThrow(){
        System.out.println("afterReturnOrThrow: работа после успешного" +
                " или ошибочного завершения метода");
    }
}
