package com.example.testtaskrestapi.controller;

import com.example.testtaskrestapi.dto.PostDto;
import com.example.testtaskrestapi.model.Post;
import com.example.testtaskrestapi.model.User;
import com.example.testtaskrestapi.repository.UserRepository;
import com.example.testtaskrestapi.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class PostController {

    private PostService postService;

    private UserRepository userRepository;

    public PostController(PostService postService,UserRepository userRepository) {
        this.postService = postService;
        this.userRepository = userRepository;
    }

    @PostMapping("/createPost")
    public ResponseEntity<String> savePost(@RequestBody PostDto postDto, @AuthenticationPrincipal UserDetails userDetails){
        User user = userRepository.findByUsername(userDetails.getUsername());
        postService.createPost(postDto, user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/posts")
    private List<Post> getAllQuotes() {
        return postService.getAllPosts();
    }

    @PutMapping("post/{id}")
    private ResponseEntity<String> updatePost(@PathVariable("id") long id,@RequestBody PostDto postDto, @AuthenticationPrincipal UserDetails userDetails) {
        String message = postService.updatePost(postDto, id, userDetails.getUsername());
        return ResponseEntity.ok(message);
    }

    @DeleteMapping("post/{id}")
    private ResponseEntity<String> deletePost(@PathVariable("id") long id, @AuthenticationPrincipal UserDetails userDetails) {
        String message = postService.deletePostById(id, userDetails.getUsername());
        return ResponseEntity.ok(message);
    }

}
