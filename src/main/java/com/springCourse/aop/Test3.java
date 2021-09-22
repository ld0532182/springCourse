package com.springCourse.aop;

import com.springCourse.aop.configAop.MyConfig;
import com.springCourse.aop.supportClasses.UniLibrary;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test3 {
    public static void main(String[] args) {

        System.out.println("Method main starts");
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

        UniLibrary uniLibrary = context.getBean("uniLibrary", UniLibrary.class);

        String book = uniLibrary.returnBook();

        System.out.println("Вернули книгу " + book);
        context.close();
        System.out.println("Method main ends");

    }
}
