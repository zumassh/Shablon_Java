package com.example.practise_22.Service;

import com.example.practise_22.DTO.PostDTO;
import com.example.practise_22.entity.Post;
import com.example.practise_22.repository.PostRepo;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PostService {
    private static final Logger log = LoggerFactory.getLogger(PostService.class);
    @Autowired
    PostRepo postRepo;

    public String createPost(PostDTO post){
        Post newPost = new Post(post);
        postRepo.save(newPost);
        log.info("Создание посылки");
        return "Посылка создана.";
    }

    public PostDTO getPost(int id){
       Optional<Post> post = postRepo.findById(id);
       log.info("Получение посылки");
       if (post.isPresent()){
           return new PostDTO(post.get());
       }
       else {
           return null;
       }
    }

    public List<PostDTO> getAllPost(){
        List<Post> posts = (List<Post>) postRepo.findAll();
        log.info("Получение всех посылок");
        if (posts != null){
            return posts.stream().map(post -> new PostDTO(post)).collect(Collectors.toList());
        }
        else{
            return null;
        }
    }

    public String deletePost(int id){
        log.info("Удаление посылки");
       postRepo.deleteById(id);
       return "Посылка с id " + id + " удалена.";
    }
}
