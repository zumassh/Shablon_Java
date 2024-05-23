package com.example.practise_24.repository;

import com.example.practise_24.entity.SessionUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSessionRepo extends CrudRepository<SessionUser, Long> {
    SessionUser findByUsername(String username);
}
