package com.example.practise_18.Service;

import com.example.practise_18.DTO.UserDTO;
import com.example.practise_18.entity.User;
import com.example.practise_18.repository.UserRepo;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class UserService {
    @Autowired
    UserRepo userRepo;

    public String createUser(UserDTO userdto){
        User newUser = new User(userdto);
        userRepo.save(newUser);
        return "Пользователь добавлен.";
    }

    public UserDTO getUser(int id){
        Optional<User> opt = userRepo.findById(id);
        if (opt.isPresent()){
            return new UserDTO(opt.get());
        }
        else{
            return null;
        }
    }

    public List<UserDTO> getAllUser(){
        List<User> users = (List<User>) userRepo.findAll();
        if (users != null){
            return users.stream().map(user -> new UserDTO(user)).collect(Collectors.toList());
        }
        else{
            return null;
        }
    }

    public String deleteUser(int id){
        userRepo.deleteById(id);
        return "Пользователь с id " + id + " удален.";
    }
}
