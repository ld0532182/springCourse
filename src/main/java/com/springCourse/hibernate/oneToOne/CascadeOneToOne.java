package com.springCourse.hibernate.oneToOne;

import com.springCourse.hibernate.oneToOne.entitys.Detail;
import com.springCourse.hibernate.oneToOne.entitys.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CascadeOneToOne {

    public static void main(String[] args) {

        biDirectionalSelect();

    }
    //Добавление через Employee
    private static void uniDirectional() {
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory()) {

            Session session = factory.getCurrentSession();
            session.beginTransaction();

            Employee employee = new Employee("Oleg", "Smirnov", "Sales", 324);
            Detail detail = new Detail("Moscow", "987654321", "tinkoff@ya.ru");
            employee.setEmpDetail(detail);
            session.save(employee);

            Employee emp = session.get(Employee.class, 6);
            System.out.println(emp.getEmpDetail());
            session.getTransaction().commit();

        }
    }
    //Добавление через detail
    private static void biDirectionalSave() {
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory()) {
            Session session = factory.getCurrentSession();
            Employee employee = new Employee("Oleg", "Makarov", "Sales", 650);
            Detail detail = new Detail("Magadan", "9112432", "leg@mail.ru");
            session.beginTransaction();
            employee.setEmpDetail(detail);
            detail.setEmployee(employee);
            session.save(detail);
            session.getTransaction().commit();
        }
    }
    private static void biDirectionalSelect(){
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory()) {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            Detail detail = session.get(Detail.class, 3);
            //Удаление detail, удалится также сотрудник из-за каскада
            session.delete(detail);

            System.out.println(detail.getEmployee());
            session.getTransaction().commit();
        }
    }

}
