package com.example.testtaskrestapi.service;

import com.example.testtaskrestapi.dto.PostDto;
import com.example.testtaskrestapi.model.Post;
import com.example.testtaskrestapi.model.User;

import java.util.List;

public interface PostService {

    PostDto createPost(PostDto postDto, User user);

    List<Post> getAllPosts();

    String updatePost(PostDto postDto, long id, String username);

    String deletePostById(long id, String username);

}
