package com.example.testtaskrestapi.service;

import com.example.testtaskrestapi.dto.PostDto;
import com.example.testtaskrestapi.model.Post;
import com.example.testtaskrestapi.model.User;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public interface PostService {

    PostDto createPost(PostDto postDto, User user);

    List<Post> getAllPosts();

    String updatePost(PostDto postDto, long id, String username);

    String deletePostById(long id, String username);

}
