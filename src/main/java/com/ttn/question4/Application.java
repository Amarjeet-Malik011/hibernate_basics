package com.ttn.question4;

import com.ttn.entity.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class Application {
    public static void main(String[] args) {
        /*Address address1=new Address(23,"vinod","delhi");
        Address address2=new Address(43,"vinod","delhi");
        Address address3=new Address(23,"vinod","delhi");
        Address address4=new Address(43,"vinod","delhi");*/

        Author author=new Author(1,"adi","k",23);
        author.setDob(new Date());
//        author.setAddress(address1);
        Author author1=new Author(2,"ravi","raj",35);
        author1.setDob(new Date());
//        author1.setAddress(address2);

        Author author2=new Author(3,"rahul","raj",30);
        author2.setDob(new Date());
//        author2.setAddress(address3);

        Author author3=new Author(4,"aman","Singh",50);
        author3.setDob(new Date());
//        author3.setAddress(address4);

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