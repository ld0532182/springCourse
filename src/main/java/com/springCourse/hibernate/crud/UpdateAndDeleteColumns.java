package com.springCourse.hibernate.crud;

import com.springCourse.hibernate.crud.entitys.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateAndDeleteColumns {

    public static void main(String[] args) {
        try(SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory()) {

            Session session = factory.getCurrentSession();
            session.beginTransaction();
            //Изменение данных
            Employee emp = session.get(Employee.class, 1);
            emp.setSalary(1000);
            //Удаление данных
            session.delete(emp);
            session.getTransaction().commit();


        }

    }

}