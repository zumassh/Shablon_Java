package com.example.practise_16.Controller;

import com.example.practise_16.DTO.UserDTO;
import com.example.practise_16.entity.User;
import com.example.practise_16.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService service;

    @PostMapping
    public String createUser(@RequestBody UserDTO user){
        return service.createUser(user);
    }

    @GetMapping
    public List<UserDTO> getUser() {
        return service.getAllUser();
    }

    @GetMapping("/{id}")
    public UserDTO getUser(@PathVariable int id){
         return service.getUser(id);
     }

     @DeleteMapping("/{id}")
     public String deleteUser(@PathVariable int id){
         return service.deleteUser(id);
     }
 }
