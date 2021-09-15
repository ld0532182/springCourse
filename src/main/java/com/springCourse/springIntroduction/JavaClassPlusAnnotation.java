package com.springCourse.springIntroduction;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaClassPlusAnnotation {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(JavaClassPlusAnnotation.class);
        Dog person = context.getBean("dog", Dog.class);
        person.say();
        context.close();


    }
}
