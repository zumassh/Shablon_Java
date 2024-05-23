package com.example.practise_24.repository;

import com.example.practise_24.entity.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepo extends CrudRepository<Post, Integer> {
}
