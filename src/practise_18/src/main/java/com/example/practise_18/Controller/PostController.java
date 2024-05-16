package com.example.practise_18.Controller;

import com.example.practise_18.DTO.PostDTO;
import com.example.practise_18.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    PostService service;

    @PostMapping
    public String createPost(@RequestBody PostDTO post){
        return service.createPost(post);
    }

    @GetMapping
    public List<PostDTO> getPost() {
        return service.getAllPost();
    }

    @GetMapping("/{id}")
    public PostDTO getPost(@PathVariable int id){
        return service.getPost(id);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id){
        return service.deletePost(id);
    }
}
