package com.example.practise_14;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    List<Post> postList = new ArrayList<>();

    @PostMapping("/create")
    public String createPost(@RequestBody Post post){
        postList.add(post);
        return "Успешно отправлено: " + post.getText() + "-" + post.getCreationDate();
    }

    @GetMapping("/getAll")
    public List<Post> getPost() {return postList;}

    @GetMapping("/get/{date}")
    public Post getPost(@PathVariable String date){
        for (Post post : postList){
            if (date.equals(post.getCreationDate())){
                return post;
            }
        }
        System.out.println("Письма в данную дату не отправлялись.");
        return null;
    }

    @DeleteMapping("/deleteAll")
    public String deleteAll(){
        postList.clear();
        return "Все письма удалены.";
    }

    @DeleteMapping("/delete/{date}")
    public String delete(@PathVariable String date){
        for (Post post : postList){
            if (date.equals(post.getCreationDate())){
                postList.remove(post);
            }
        }
        return "Удалены письма, отправленные " + date;
    }
}
