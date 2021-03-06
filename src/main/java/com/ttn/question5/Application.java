package com.ttn.question5;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Application{
    public static void main(String[] args) {

        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();

        Session session=sessionFactory.openSession();

        session.beginTransaction();

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}