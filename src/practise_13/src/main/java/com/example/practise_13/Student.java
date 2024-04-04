package com.example.practise_13;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student {
    @Value("${program.student.name}")
    String name;
    @Value("${program.student.lastname}")
    String lastname;
    @Value("${program.student.group}")
    String group;

    @PostConstruct
    public void init(){
        System.out.println(name);
        System.out.println(lastname);
        System.out.println(group);
    }
}
