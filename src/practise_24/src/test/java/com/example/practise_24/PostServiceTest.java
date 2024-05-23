package com.example.practise_24;

import com.example.practise_24.DTO.PostDTO;
import com.example.practise_24.Service.PostService;
import com.example.practise_24.entity.Post;
import com.example.practise_24.entity.User;
import com.example.practise_24.repository.PostRepo;
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
public class PostServiceTest {

    @Mock
    private PostRepo postRepo;

    @InjectMocks
    private PostService postService;

    private Post post;
    private PostDTO postDTO;

    @BeforeEach
    public void setup() {
        User owner = new User();
        owner.setId(1);
        post = new Post();
        post.setId(1);
        post.setOwner(owner);
        postDTO = new PostDTO(post);
    }

    @Test
    public void testCreatePost() {
        when(postRepo.save(any(Post.class))).thenReturn(post);
        String response = postService.createPost(postDTO);
        assertEquals("Посылка создана.", response);
        verify(postRepo).save(any(Post.class));
    }

    @Test
    public void testGetPostFound() {
        when(postRepo.findById(1)).thenReturn(Optional.of(post));
        PostDTO found = postService.getPost(1);
        assertEquals(postDTO, found);
    }

    @Test
    public void testGetPostNotFound() {
        when(postRepo.findById(1)).thenReturn(Optional.empty());
        PostDTO result = postService.getPost(1);
        assertNull(result);
    }

    @Test
    public void testGetAllPosts() {
        when(postRepo.findAll()).thenReturn(Arrays.asList(post));
        List<PostDTO> posts = postService.getAllPost();
        assertFalse(posts.isEmpty());
        assertEquals(1, posts.size());
        assertEquals(postDTO, posts.get(0));
    }

    @Test
    public void testDeletePost() {
        doNothing().when(postRepo).deleteById(1);
        String response = postService.deletePost(1);
        assertEquals("Посылка с id 1 удалена.", response);
        verify(postRepo).deleteById(1);
    }
}