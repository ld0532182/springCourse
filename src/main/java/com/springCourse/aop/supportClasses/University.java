package com.springCourse.aop.supportClasses;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class University {

    private List<Student> students = new ArrayList<>();

    public void addStudents(){
        Student str1 = new Student("Ivan Ivanov", 4, 7.6);
        Student str2 = new Student("Roman Petrov", 2, 8.1);
        Student str3 = new Student("Elena Sidorova", 1, 9.5);

        students.add(str1);
        students.add(str2);
        students.add(str3);
    }

    public List<Student> getStudents(){
        System.out.println("Информация из метода getStudents:");
        //students.get(3);
        System.out.println(students);
        return students;
    }

}
