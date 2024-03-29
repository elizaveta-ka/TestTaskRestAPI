package com.example.testtaskrestapi.service.impl;

import com.example.testtaskrestapi.dto.PostDto;
import com.example.testtaskrestapi.exception.APIException;
import com.example.testtaskrestapi.model.Post;
import com.example.testtaskrestapi.model.User;
import com.example.testtaskrestapi.repository.PostRepository;
import com.example.testtaskrestapi.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto, User user) {

        if(postDto.getTitle() == "") {
            throw new APIException(HttpStatus.BAD_REQUEST, "Title should not be empty");
        }
        if(postDto.getText() == "") {
            throw new APIException(HttpStatus.BAD_REQUEST, "Text should not be empty");
        }

        Post newPost = new Post();
        newPost.setTitle(postDto.getTitle());
        newPost.setText(postDto.getText());
        newPost.setImage(postDto.getImage());
        newPost.setUser(user);
        newPost.setDatePost(LocalDateTime.now());
        postRepository.save(newPost);
        return postDto;
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public String updatePost(PostDto postDto, long id, String username) {

        if(postDto.getTitle() == "") {
            throw new APIException(HttpStatus.BAD_REQUEST, "Title should not be empty");
        }
        if(postDto.getText() == "") {
            throw new APIException(HttpStatus.BAD_REQUEST, "Text should not be empty");
        }

        Post oldPost = postRepository.getById(id);
        System.out.println(oldPost.getUser().getUsername());

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
