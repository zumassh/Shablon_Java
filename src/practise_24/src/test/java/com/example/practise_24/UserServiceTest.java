package com.example.practise_24;

import com.example.practise_24.DTO.UserDTO;
import com.example.practise_24.Service.UserService;
import com.example.practise_24.entity.User;
import com.example.practise_24.repository.UserRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepo userRepo;

    @InjectMocks
    private UserService userService;

    private User user;
    private UserDTO userDTO;

    @BeforeEach
    public void setup() {
        user = new User(); // Подходящая инициализация в зависимости от структуры класса User
        user.setId(1); // Предположим, что у User есть метод setId
        userDTO = new UserDTO(user); // Предположим, что конструктор UserDTO принимает объект User
    }

    @Test
    public void testCreateUser() {
        when(userRepo.save(any(User.class))).thenReturn(user);
        String response = userService.createUser(userDTO);
        assertEquals("Пользователь добавлен.", response);
        verify(userRepo).save(any(User.class));
    }

    @Test
    public void testGetUserFound() {
        when(userRepo.findById(1)).thenReturn(Optional.of(user));
        UserDTO found = userService.getUser(1);
        assertEquals(userDTO, found);
    }

    @Test
    public void testGetUserNotFound() {
        when(userRepo.findById(1)).thenReturn(Optional.empty());
        UserDTO result = userService.getUser(1);
        assertNull(result);
    }

    @Test
    public void testGetAllUsers() {
        when(userRepo.findAll()).thenReturn(Arrays.asList(user));
        List<UserDTO> users = userService.getAllUser();
        assertFalse(users.isEmpty());
        assertEquals(1, users.size());
        assertEquals(userDTO, users.get(0));
    }

    @Test
    public void testDeleteUser() {
        doNothing().when(userRepo).deleteById(1);
        String response = userService.deleteUser(1);
        assertEquals("Пользователь с id 1 удален.", response);
        verify(userRepo).deleteById(1);
    }
}