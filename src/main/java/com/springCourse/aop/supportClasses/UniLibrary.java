package com.springCourse.aop.supportClasses;

import org.springframework.stereotype.Component;

@Component
public class UniLibrary extends AbstractLibrary {

    private String book;

    @Override
    public void getBook() {
        System.out.println("UniLibrary: берем книгу\n-----------------");
    }

    public void getBook(String book) {
        System.out.println("UniLibrary: берем книгу " + book + "\n-----------------");
    }

    public void getMagazine() {
        System.out.println("UniLibrary: берем журнал\n-----------------");
    }

    public String returnBook() {
        int i = 10/0;
        System.out.println("UniLibrary: возвращаем книгу\n-----------------");
        return "bookX";
    }

    public void addBook(String whoAdd, String book){
        System.out.println(whoAdd + " возвращает " + book + "\n-----------------");
    }
}
