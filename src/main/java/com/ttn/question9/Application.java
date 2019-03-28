package com.ttn.question9;

import com.ttn.entity.Address;
import com.ttn.entity.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class Application{
    public static void main(String[] args) {

        Address address1=new Address(23,"vinod","delhi");
        Address address2=new Address(43,"vinod","delhi");
        Address address3=new Address(23,"vinod","delhi");
        Address address4=new Address(43,"vinod","delhi");

        Author author=new Author("Aditya","kr",23,new Date());
        author.setAddress(address1);
        Author author1=new Author("Rahul","pandey",35,new Date());
        author1.setAddress(address2);
        Author author2=new Author("Aman","dixit",30,new Date());
        author2.setAddress(address3);
        Author author3=new Author("Sumit","Singh",40,new Date());
        author3.setAddress(address4);
        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();

        Session session=sessionFactory.openSession();
        session.beginTransaction();

        session.save(author);
        session.save(author1);
        session.save(author2);
        session.save(author3);

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}