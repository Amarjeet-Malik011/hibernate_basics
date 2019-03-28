package com.ttn.question11;


import com.ttn.entity.Address;
import com.ttn.entity.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class Application{
    public static void main(String[] args) {
        Author author=new Author("Aditya","kumar",23,new Date());

        Address address=new Address();
        address.setLocation("Virar");
        address.setState("Mumbai");
        address.setStreetNumber(3);

        author.setAddress(address);

        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();

        Session session=sessionFactory.openSession();

        session.beginTransaction();

        session.save(author);

        session.getTransaction().commit();
    }
}