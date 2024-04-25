package com.example.practise_15.Service;

import com.example.practise_15.entity.Post;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;

@Component
public class PostService {
    private final SessionFactory factory;
    @Autowired
    public PostService(SessionFactory factory){
        this.factory = factory;
    }

    public String createPost(Post post){
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            session.save(post);
            session.getTransaction().commit();
            return "Посылка добавлена.";
        }
        catch (Exception e) {
            return e.getMessage();
        }
        finally {
            session.close();
        }
    }

    public Post getPost(int id){
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            Post post = session.get(Post.class, id);
            session.getTransaction().commit();
            return post;
        }
        catch (Exception e) {
            return null;
        }
        finally {
            session.close();
        }
    }

    public List<Post> getAllPost(){
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            Query<Post> query = session.createQuery("FROM Post", Post.class);
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

    public String deletePost(int id){
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            Post post = session.get(Post.class, id);
            session.remove(post);
            session.getTransaction().commit();
            return "Запись с id " + id + " удалена.";
        }
        catch (Exception e) {
            return e.getMessage();
        }
        finally {
            session.close();
        }
    }
}
