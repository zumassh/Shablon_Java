package com.example.practise_17.Service;

import com.example.practise_17.DTO.PostDTO;
import com.example.practise_17.entity.Post;
import com.example.practise_17.entity.User;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class PostService {
    private final SessionFactory factory;
    @Autowired
    public PostService(SessionFactory factory){
        this.factory = factory;
    }

    public String createPost(PostDTO post){
        Session session = null;
        try {
            Post newPost = new Post(post);
            session = factory.openSession();
            session.beginTransaction();
            User user = session.get(User.class, post.getOwnerId());
            newPost.setOwner(user);
            user.addPost(newPost);
            session.persist(newPost);
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

    public PostDTO getPost(int id){
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            Post post = session.get(Post.class, id);
            session.getTransaction().commit();
            return new PostDTO(post);
        }
        catch (Exception e) {
            return null;
        }
        finally {
            session.close();
        }
    }

    public List<PostDTO> getPostByFilter(Map<String, Object> filter){
        System.out.println("filter");

        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            if (filter.get("ownerId") != null){
                filter.put("owner", session.get(User.class, filter.get("ownerId")));
                filter.remove("ownerId");
            }
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Post> query = builder.createQuery(Post.class);
            Root<Post> root = query.from(Post.class);
            Predicate[] predicate = filter.entrySet().stream().map(entry -> {
                String key = entry.getKey();
                Object value = entry.getValue();
                return builder.equal(root.get(key), value);
            }).toArray(Predicate[]::new);
            query.select(root).where(predicate);
            List<Post> postList = session.createQuery(query).getResultList();
            session.getTransaction().commit();
            return postList.stream().map(post -> new PostDTO(post)).collect(Collectors.toList());
        }
        finally{
            session.close();
        }
    }

    public List<PostDTO> getAllPost(){
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            Query<Post> query = session.createQuery("FROM Post", Post.class);
            session.getTransaction().commit();
            return query.list().stream().map(post -> new PostDTO(post)).collect(Collectors.toList());
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
            session.delete(post);
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
