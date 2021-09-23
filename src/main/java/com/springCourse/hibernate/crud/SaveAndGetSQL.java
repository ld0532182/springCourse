package com.springCourse.hibernate.crud;

import com.springCourse.hibernate.crud.entitys.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SaveAndGetSQL {

    public static void main(String[] args) {

        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory()) {
            //INSERT INTO employees (..) VALUES (..);
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            Employee employee = new Employee("Ekaterina", "Surkova", "Sales", 640);
            session.save(employee);
            session.getTransaction().commit();
            System.out.println(employee);

            //SELECT * FROM employees WHERE id = 1;
            session = factory.getCurrentSession();
            session.beginTransaction();
            Employee employee1 = session.get(Employee.class, 1);
            session.getTransaction().commit();
            System.out.println(employee1);


        }
    }
}
