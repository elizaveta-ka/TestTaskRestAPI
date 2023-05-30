package com.example.testtaskrestapi.controller;

import com.example.testtaskrestapi.model.Post;
import com.example.testtaskrestapi.repository.PostRepository;
import com.example.testtaskrestapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class ActivityFeedController {

    private PostRepository postRepository;

    private UserRepository userRepository;


    @Autowired
    public ActivityFeedController(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/feed")
    public Page<Post> getFeed(@RequestParam(defaultValue = "0") int page,
                              @RequestParam(defaultValue = "2") int quantity,
                              @AuthenticationPrincipal User user) {
            long id = userRepository.findByUsername(user.getUsername()).getId();
            Pageable pageBl = PageRequest.of(page, quantity);
            return postRepository.findLastPostsSubscribers(id,pageBl);
        }
    }
