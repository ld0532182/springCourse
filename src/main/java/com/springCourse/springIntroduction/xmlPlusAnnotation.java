package com.springCourse.springIntroduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class xmlPlusAnnotation {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContextWithAnnotation.xml");
        Person person = context.getBean("personBean", Person.class);
        person.callYourPet();
        System.out.println(person.getAge());
        System.out.println(person.getSurname());

        context.close();

    }
}
