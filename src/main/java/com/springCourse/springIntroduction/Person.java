package com.springCourse.springIntroduction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("personBean")
public class Person {
    //можно также определять даже(рефлексия) приватные поля с помощью аннотации
    @Autowired
    //Аннотация для определения типа, в случае совпадений
    @Qualifier("catBean")
    private Pet pet;
    @Value("${person.surname}")
    private String surname;
    @Value("${person.age}")
    private int age;

    public Person(){
        System.out.println("Person was created");
    }
/*    @Autowired
    public Person(//!Аннотация для конструктора/ @Qualifier("catBean") Pet pet) {
        System.out.println("Person bean is created with 'Pet' argument");
        this.pet = pet;
    }*/

    public Person(Pet pet){
        this.pet = pet;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        System.out.println("Set surname");
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        System.out.println("Set age");
        this.age = age;
    }

    // pet -> setPet
    //Для сеттеров также можно использовать аннотацию
    //@Autowired
    //Аннотация для сеттера
    //@Qualifier("catBean")
    public void setPet(Pet pet) {
        System.out.println("Class Person set pet");
        this.pet = pet;
    }

    public void callYourPet(){
        System.out.println("Hello, pet");
        pet.say();
    }

    public void init(){
        System.out.println("Person Init method");
    }

    public void destroy(){
        System.out.println("Person Destroy method");
    }

    @Override
    public String toString() {
        return "Person{" +
                "pet=" + pet +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }
}
