package com.ttn.question2;

import com.ttn.entity.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Application {
    public static void main(String[] args) {
        Author author=new Author(1,"Amarjeet","Malik",21);
        Author author2=new Author(2,"Aditya","Kumar",22);

        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        //create
        session.save(author);
        session.save(author2);
        //read
        Author author1=session.get(Author.class,1);
        System.out.println("Author with Id 1: "+author1);
        //update
        author1.setFirstName("Bingo");
        session.update(author1);
        Author author3=session.get(Author.class,1);
        System.out.println("Author with id 1 after update"+author3);
        //delete
        session.delete(author1);
        session.getTransaction().commit();
    }
}
