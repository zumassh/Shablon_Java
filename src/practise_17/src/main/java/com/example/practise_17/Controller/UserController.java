package com.example.practise_17.Controller;

import com.example.practise_17.DTO.UserDTO;
import com.example.practise_17.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    public List<UserDTO> getUser(@RequestParam Map<String, Object> filter) {
        if (filter.isEmpty())
            return service.getAllUser();
        return service.getUserByFilter(filter);
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
