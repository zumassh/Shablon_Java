package com.example.practise_18.Service;

import com.example.practise_18.DTO.PostDTO;
import com.example.practise_18.entity.Post;
import com.example.practise_18.entity.User;
import com.example.practise_18.repository.PostRepo;
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
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PostService {
    @Autowired
    PostRepo postRepo;

    public String createPost(PostDTO post){
        Post newPost = new Post(post);
        postRepo.save(newPost);
        return "Посылка создана.";
    }

    public PostDTO getPost(int id){
       Optional<Post> post = postRepo.findById(id);
       if (post.isPresent()){
           return new PostDTO(post.get());
       }
       else {
           return null;
       }
    }

    public List<PostDTO> getAllPost(){
        List<Post> posts = (List<Post>) postRepo.findAll();
        if (posts != null){
            return posts.stream().map(post -> new PostDTO(post)).collect(Collectors.toList());
        }
        else{
            return null;
        }
    }

    public String deletePost(int id){
       postRepo.deleteById(id);
       return "Посылка с id " + id + " удалена.";
    }
}
