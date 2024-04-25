package com.example.practise_15.Controller;

import com.example.practise_15.entity.User;
import com.example.practise_15.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService service;

    @PostMapping
    public String createUser(@RequestBody User user){
        return service.createUser(user);
    }

    @GetMapping
    public List<User> getUser() {
        return service.getAllUser();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable int id){
         return service.getUser(id);
     }

     @DeleteMapping("/{id}")
     public String deleteUser(@PathVariable int id){
         return service.deleteUser(id);
     }
 }
