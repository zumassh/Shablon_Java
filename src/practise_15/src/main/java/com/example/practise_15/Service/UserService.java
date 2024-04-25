package com.example.practise_15.Service;

import com.example.practise_15.entity.Post;
import com.example.practise_15.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;

@Component
public class UserService {
    private final SessionFactory factory;
    @Autowired
    public UserService(SessionFactory factory){
        this.factory = factory;
    }

    public String createUser(User user){
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
            return "Пользователь добавлен.";
        }
        catch (Exception e) {
            return e.getMessage();
        }
        finally {
            session.close();
        }
    }

    public User getUser(int id){
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            User user = session.get(User.class, id);
            session.getTransaction().commit();
            return user;
        }
        catch (Exception e) {
            return null;
        }
        finally {
            session.close();
        }
    }

    public List<User> getAllUser(){
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            Query<User> query = session.createQuery("FROM User", User.class);
            session.getTransaction().commit();
            return query.list();
        }
        catch (Exception e) {
            return null;
        }
        finally {
            session.close();
        }
    }

    public String deleteUser(int id){
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            User user = session.get(User.class, id);
            session.remove(user);
            session.getTransaction().commit();
            return "Пользователь с id " + id + " удален.";
        }
        catch (Exception e) {
            return e.getMessage();
        }
        finally {
            session.close();
        }
    }
}
