package com.ttn.question17;

import com.ttn.entity.Address;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Application{
    public static void main(String[] args) {

        Address address=new Address();
        address.setLocation("vinod nagar");
        address.setState("Delhi");
        address.setStreetNumber(6);

        Author author=new Author("Aditya","kumar",23,new Date());
        author.setAddress(address);
//        author.setSubjectList(Arrays.asList("Science","History","Maths"));
        List<String> stringList = new ArrayList<>();
        stringList.add("Hindi");
        stringList.add("Biology");
        stringList.add("Math");
        author.setSubjectList(stringList);


        Author author1=new Author("Ali","pirkhan",25,new Date());
        author1.setAddress(address);
        author1.setSubjectList(Arrays.asList("Science","urdu","Maths"));



        Book book1=new Book();
        book1.setBookName("Introduction to darkworld");
        book1.getAuthorSet().addAll(Arrays.asList(author,author1));


        Book book2=new Book();
        book2.setBookName("Introdunction to java");
        book2.getAuthorSet().addAll(Arrays.asList(author,author1));

        author.getBookSet().addAll(Arrays.asList(book1,book2));

        author1.getBookSet().addAll(Arrays.asList(book1,book2));


        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();

        Session session=sessionFactory.openSession();
        session.beginTransaction();

        session.persist(author);
        session.persist(author1);


        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}