package com.springCourse.springIntroduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class xmlControl {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContextForXml.xml");

        Pet pet = context.getBean("myPet", Pet.class);
        pet.say();

        Person person = context.getBean("myPerson", Person.class);
        System.out.println(person);
        context.close();


    }


}
