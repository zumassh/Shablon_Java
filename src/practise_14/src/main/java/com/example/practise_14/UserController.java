package com.example.practise_14;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    List<User> userList = new ArrayList<>();

    @PostMapping("/create")
    public String createUser(@RequestBody User user){
        userList.add(user);
        return "Новый пользователь: " + user.getFirstName() + " " + user.getLastName() +  " " + user.getMiddleName() +  " " + user.getBirthDate();
    }

    @GetMapping("/getAll")
    public List<User> getUser(){
        return userList;
    }

    @GetMapping("/get/{firstName}")
    public User getUser(@PathVariable String firstName){
        for (User user : userList){
            if (user.getFirstName().equals(firstName)){
                return user;
            }
        }
        return null;
    }

    @DeleteMapping("/delete/{firstName}")
    public String deleteUser(@PathVariable String firstName){
        for (User user : userList){
            if (user.getFirstName().equals(firstName)){
                userList.remove(user);
                return "Удален пользователь: " + user.getFirstName() + " " + user.getLastName() +  " " + user.getMiddleName() +  " " + user.getBirthDate();
            }
        }
        return "Пользователь не найден.";
    }

    @DeleteMapping("/deleteAll")
    public String deleteAll(){
        userList.clear();
        return "Список пользователей очищен. Все пользователи удалены.";
    }

}
