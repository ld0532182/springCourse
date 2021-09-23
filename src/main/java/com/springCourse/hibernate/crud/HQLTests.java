package com.springCourse.hibernate.crud;

import com.springCourse.hibernate.crud.entitys.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HQLTests {

    public static void main(String[] args) {

        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory()) {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            //Пишем имя класса, а не таблицы
            //select
            List<Employee> emps = session.createQuery("FROM Employee WHERE surname LIKE 'Ovechkin%'")
                    .getResultList();

            //update
            session.createQuery("UPDATE Employee SET salary = 1500 WHERE surname LIKE 'Ovechkin%'")
                    .executeUpdate();

            //delete
            session.createQuery("DELETE Employee WHERE surname LIKE 'Ovechkin%'")
                    .executeUpdate();

            for (Employee e : emps) {
                System.out.println(e);
            }
            session.getTransaction().commit();
        }
    }
}