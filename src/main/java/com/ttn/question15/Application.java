package com.ttn.question15;


import com.ttn.entity.Address;
import com.ttn.entity.Author;
import com.ttn.entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Application{
    public static void main(String[] args) {
        Book book=new Book();
        book.setBookName("Introduction to dark world");

        Address address=new Address();
        address.setLocation("A.K.dixit");
        address.setState("Bihar");
        address.setStreetNumber(4);

        Author author=new Author(1,"Aditya","Kumar",23);
        author.setDob(new Date());
        author.setAddress(address);
//        author.setSubjectList(Arrays.asList("Science","History","Maths"));
        List<String> stringList = new ArrayList<>();
        stringList.add("Hindi");
        stringList.add("Biology");
        stringList.add("Math");
        author.setSubjectList(stringList);
        author.setBook(book);

        Author author1=new Author(2,"Ali","Pirkhan",25);
        author1.setDob(new Date());
        author1.setAddress(address);
        author1.setSubjectList(Arrays.asList("Hindi","urdu","Spring"));
        author1.setBook(book);

        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();

        Session session=sessionFactory.openSession();
        session.beginTransaction();

        session.save(book);

        session.save(author);
        session.save(author1);

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}
