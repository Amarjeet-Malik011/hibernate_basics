package com.ttn.question13;

import com.ttn.entity.Address;
import com.ttn.entity.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Application{
    public static void main(String[] args) {

        Address address1=new Address(23,"vinod","delhi");
        Address address2=new Address(43,"vinod","delhi");

        Author author=new Author("Aditya","kr",23,new Date());
        author.setAddress(address1);

        List<String> stringList = new ArrayList<>();
        stringList.add("Hindi");
        stringList.add("Biology");
        stringList.add("Math");
        author.setSubjectList(stringList);

        Author author1=new Author("Ali","pirkhan",34,new Date());
        author1.setAddress(address2);
//        author1.setSubjectList(Arrays.asList("Hindi","urdu","Spring"));

        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();

        Session session=sessionFactory.openSession();
        session.beginTransaction();

        session.save(author);
        session.save(author1);

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}