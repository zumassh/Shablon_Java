package com.example.practise_21.Service;

import com.example.practise_21.DTO.UserDTO;
import com.example.practise_21.entity.User;
import com.example.practise_21.repository.UserRepo;
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
@Transactional
@Slf4j
public class UserService {
    private static final Logger log = LoggerFactory.getLogger(UserService.class);
    @Autowired
    UserRepo userRepo;
    @Autowired
    EmailService emailService;

    public String createUser(UserDTO userdto){
        User newUser = new User(userdto);
        userRepo.save(newUser);
        log.info("Создание пользователя");
        emailService.sendEmail("Создание пользователя.");
        return "Пользователь добавлен.";
    }

    public UserDTO getUser(int id){
        Optional<User> opt = userRepo.findById(id);
        log.info("Получение пользователя");
        emailService.sendEmail("Получение пользователя.");
        if (opt.isPresent()){
            return new UserDTO(opt.get());
        }
        else{
            return null;
        }
    }

    public List<UserDTO> getAllUser(){
        log.info("Получение всех пользователей");
        emailService.sendEmail("Получение всех пользователей.");
        List<User> users = (List<User>) userRepo.findAll();
        if (users != null){
            return users.stream().map(user -> new UserDTO(user)).collect(Collectors.toList());
        }
        else{
            return null;
        }
    }

    public String deleteUser(int id){
        log.info("Удаление пользователя");
        emailService.sendEmail("Удаление пользователя.");
        userRepo.deleteById(id);
        return "Пользователь с id " + id + " удален.";
    }
}
