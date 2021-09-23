package com.springCourse.hibernate.oneToMany;

import com.springCourse.hibernate.oneToMany.entitys.Department;
import com.springCourse.hibernate.oneToMany.entitys.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToManyMain {
    public static void main(String[] args) {

        getEmployeeAndDepartment();

    }

    //Получаем сотрудника и узнаем информацию о департаменте
    private static void getEmployeeAndDepartment() {
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory()) {
            Session session = factory.getCurrentSession();
            session.beginTransaction();


            Employee employee = session.get(Employee.class, 10);
            System.out.println(employee.getDepartment());
            session.delete(employee);
            session.getTransaction().commit();
        }
    }


    //Получение информации о департаменте и рабочих через каскад
    private static void getDepartment() {
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory()) {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            Department department = session.get(Department.class, 1);
            System.out.println(department);
            System.out.println(department.getEmps());

            session.getTransaction().commit();


        }
    }


    //Добавление департамента и сотрудников.
    private static void addDepartment() {
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory()) {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            Department dep = new Department("IT", 300, 1200);

            Employee emp1 = new Employee("Van", "Ivanov", 800);
            Employee emp2 = new Employee("Elena", "Smirnova", 1000);

            dep.addEmployeeToDepartment(emp1);
            dep.addEmployeeToDepartment(emp2);

            session.save(dep);

            session.getTransaction().commit();
        }
    }
}

