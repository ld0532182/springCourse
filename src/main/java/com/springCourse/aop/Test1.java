package com.springCourse.aop;

import com.springCourse.aop.configAop.MyConfig;
import com.springCourse.aop.supportClasses.SchoolLibrary;
import com.springCourse.aop.supportClasses.UniLibrary;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test1 {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

        UniLibrary uniLibrary = context.getBean("uniLibrary", UniLibrary.class);
        uniLibrary.getBook();
        uniLibrary.getBook("Book1");
        uniLibrary.getMagazine();
        uniLibrary.returnBook();

        uniLibrary.addBook("Ivan", "book1");

        SchoolLibrary schoolLibrary = context.getBean("schoolLibrary", SchoolLibrary.class);
        schoolLibrary.getBook();
        context.close();

    }
}
