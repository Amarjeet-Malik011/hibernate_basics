package com.ttn.question16.unidirectional;

import com.ttn.entity.Address;
import com.ttn.entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.Date;

public class Application{
    public static void main(String[] args) {

        Address address=new Address();
        address.setLocation("vinod nagar");
        address.setState("Delhi");
        address.setStreetNumber(6);

        Author author=new Author("Aditya","Kumar",23,new Date());
        author.setDob(new Date());
        author.setAddress(address);
        author.setSubjectList(Arrays.asList("Science","History","Maths"));

        Book book1=new Book();
        book1.setBookName("Introduction to dark web");

        Book book2=new Book();
        book2.setBookName("Introdunction to java");


        author.getBookSet().addAll(Arrays.asList(book1,book2));


        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();

        Session session=sessionFactory.openSession();
        session.beginTransaction();

        session.save(book1);
        session.save(book2);

        session.save(author);

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}
