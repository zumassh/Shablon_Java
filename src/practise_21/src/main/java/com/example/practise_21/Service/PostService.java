package com.example.practise_21.Service;

import com.example.practise_21.DTO.PostDTO;
import com.example.practise_21.entity.Post;
import com.example.practise_21.repository.PostRepo;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@Transactional
public class PostService {
    private static final Logger log = LoggerFactory.getLogger(PostService.class);
    @Autowired
    PostRepo postRepo;
    @Autowired
    EmailService emailService;

    public String createPost(PostDTO post){
        Post newPost = new Post(post);
        postRepo.save(newPost);
        log.info("Создание посылки");
        emailService.sendEmail("Создание посылки.");
        return "Посылка создана.";
    }

    public PostDTO getPost(int id){
       Optional<Post> post = postRepo.findById(id);
       log.info("Получение посылки");
       emailService.sendEmail("Получение посылки.");
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
        emailService.sendEmail("Получение всех посылок.");
        if (posts != null){
            return posts.stream().map(post -> new PostDTO(post)).collect(Collectors.toList());
        }
        else{
            return null;
        }
    }

    public String deletePost(int id){
        log.info("Удаление посылки");
        emailService.sendEmail("Удаление посылки.");
       postRepo.deleteById(id);
       return "Посылка с id " + id + " удалена.";
    }
}
