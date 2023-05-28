package com.example.testtaskrestapi.service.impl;

import com.example.testtaskrestapi.dto.PostDto;
import com.example.testtaskrestapi.model.Post;
import com.example.testtaskrestapi.model.User;
import com.example.testtaskrestapi.repository.PostRepository;
import com.example.testtaskrestapi.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;


    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto, User user) {
        Post newPost = new Post();
        newPost.setTitle(postDto.getTitle());
        newPost.setText(postDto.getText());
        newPost.setImage(postDto.getImage());
        newPost.setUser(user);
        postRepository.save(newPost);
        return postDto;
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public String updatePost(PostDto postDto, long id, String username) {
        Post oldPost = postRepository.getById(id);
        if(oldPost.getUser().getUsername().equals(username)) {
            oldPost.setText(postDto.getText());
            oldPost.setTitle(postDto.getTitle());
            oldPost.setImage(postDto.getImage());
            postRepository.save(oldPost);
            return "ok";
        } else return "You cannot edit this post";
    }

    @Override
    public String deletePostById(long id, String username) {
        Post oldPost = postRepository.getById(id);
        if(oldPost.getUser().getUsername().equals(username)) {
            postRepository.deleteById(id);
            return "ok";
        } else return "You cannot delete this post";
    }
}
