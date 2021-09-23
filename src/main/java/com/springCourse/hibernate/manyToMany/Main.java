package com.springCourse.hibernate.manyToMany;

import com.springCourse.hibernate.manyToMany.entitys.Child;
import com.springCourse.hibernate.manyToMany.entitys.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {
        getInformation();
    }

    private static void getInformation(){
        try(SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory()) {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            Child child = session.get(Child.class, 4);

            System.out.println(child.getSections());

            Section section = session.get(Section.class, 1);

            System.out.println(section.getName());
            System.out.println(section.getChildren());

            session.getTransaction().commit();
        }
    }

    private static void saveChild(){
        try(SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory()) {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            Child child = new Child("Gena", 6);

            Section section1 = new Section("Swim");
            Section section2= new Section("Chess");
            Section section3 = new Section("Volleyball");

            child.addSectionToChild(section1);
            child.addSectionToChild(section2);
            child.addSectionToChild(section3);

            session.save(child);

            session.getTransaction().commit();
        }

    }
    private static void saveSection(){
        try(SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory()){
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            Section section1 = new Section("Football");
            Child child1 = new Child("Oleg", 5);
            Child child2 = new Child("Vasya", 8);
            Child child3 = new Child("Nikita", 10);

            section1.addChildToSection(child1);
            section1.addChildToSection(child2);
            section1.addChildToSection(child3);

            session.save(section1);

            session.getTransaction().commit();
        }
    }
}
