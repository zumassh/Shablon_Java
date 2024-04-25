package com.example.practise_16.Service;

import com.example.practise_16.DTO.UserDTO;
import com.example.practise_16.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserService {
    private final SessionFactory factory;
    @Autowired
    public UserService(SessionFactory factory){
        this.factory = factory;
    }

    public String createUser(UserDTO userdto){
        User user = new User(userdto);
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

    public UserDTO getUser(int id){
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            User user = session.get(User.class, id);
            session.getTransaction().commit();
            return new UserDTO(user);
        }
        catch (Exception e) {
            return null;
        }
        finally {
            session.close();
        }
    }

    public List<UserDTO> getAllUser(){
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            Query<User> query = session.createQuery("FROM User", User.class);
            session.getTransaction().commit();
            List<User> users = query.list();
            List<UserDTO> userDTOS = new ArrayList<>();
            userDTOS = users.stream().map(user -> new UserDTO(user)).collect(Collectors.toList());
            return userDTOS;
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
