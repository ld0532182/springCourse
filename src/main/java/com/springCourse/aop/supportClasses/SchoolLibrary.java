package com.springCourse.aop.supportClasses;

import org.springframework.stereotype.Component;

@Component
public class SchoolLibrary extends AbstractLibrary{

    @Override
    public void getBook() {
        System.out.println("SchoolLibrary: берем книгу\n-----------------");
    }
}
