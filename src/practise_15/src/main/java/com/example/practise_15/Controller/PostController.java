package com.example.practise_15.Controller;

import com.example.practise_15.Service.PostService;
import com.example.practise_15.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    PostService service;

    @PostMapping
    public String createPost(@RequestBody Post post){
        return service.createPost(post);
    }

    @GetMapping
    public List<Post> getPost() {
        return service.getAllPost();
    }

    @GetMapping("/{id}")
    public Post getPost(@PathVariable int id){
        return service.getPost(id);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id){
        return service.deletePost(id);
    }
}
