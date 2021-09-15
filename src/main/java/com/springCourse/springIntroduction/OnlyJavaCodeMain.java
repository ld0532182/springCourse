package com.springCourse.springIntroduction;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OnlyJavaCodeMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(OnlyJavaCodeConfig.class);
        Pet cat = context.getBean("catBean", CatAnnotation.class);
        cat.say();
        Person person = context.getBean("personBean", Person.class);
        context.close();

    }
}
