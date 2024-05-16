package com.example.practise_20.repository;

import com.example.practise_20.entity.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepo extends CrudRepository<Post, Integer> {
}
