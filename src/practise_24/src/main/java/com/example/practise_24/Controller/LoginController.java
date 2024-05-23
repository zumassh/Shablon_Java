package com.example.practise_24.Controller;

import com.example.practise_24.DTO.UserRegistrationDTO;
import com.example.practise_24.entity.SessionUser;
import com.example.practise_24.repository.UserSessionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
    @Autowired
    UserSessionRepo userSessionRepo;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String getLogin(){
        return "login";
    }
    @GetMapping("/register")
    public String getReg(){
        return "register";
    }
    @PostMapping("/register")
    public ModelAndView registerUser(UserRegistrationDTO registrationDto){
        if (!registrationDto.getPassword().equals(registrationDto.getConfirmPassword())) {
            return new ModelAndView("register", "error", "Passwords do not match");
        }
        SessionUser newUser = new SessionUser();
        System.out.println(registrationDto);
        newUser.setUsername(registrationDto.getUsername());
        newUser.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
        userSessionRepo.save(newUser);
        return new ModelAndView("login", "success", "Registration successful");
    }

    @PostMapping("/login")
    public ModelAndView login(String username, String password) {
        // Проверяем, существует ли пользователь с заданным именем пользователя
        if (userSessionRepo.findByUsername(username) != null) {
            // Если пользователь существует, передаем управление Spring Security для аутентификации
            return new ModelAndView("redirect:/authenticate");
        } else {
            // Если пользователь не существует, возвращаем сообщение об ошибке
            ModelAndView modelAndView = new ModelAndView("login");
            modelAndView.addObject("error", "User not found");
            return modelAndView;
        }
    }
}