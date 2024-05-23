package com.example.practise_24.Service;

import com.example.practise_24.repository.UserSessionRepo;
import com.example.practise_24.entity.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserSessionRepo userSessionRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SessionUser sessionUser = userSessionRepo.findByUsername(username);
        if (sessionUser == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return User.withUsername(sessionUser.getUsername()).password(sessionUser.getPassword()).roles("USER").build();
    }
}