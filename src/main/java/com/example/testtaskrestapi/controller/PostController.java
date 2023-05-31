package com.example.testtaskrestapi.controller;

import com.example.testtaskrestapi.dto.PostDto;
import com.example.testtaskrestapi.model.Post;
import com.example.testtaskrestapi.model.User;
import com.example.testtaskrestapi.repository.PostRepository;
import com.example.testtaskrestapi.repository.UserRepository;
import com.example.testtaskrestapi.service.PostService;
import com.example.testtaskrestapi.service.impl.PostServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@Tag(name="Post Controller", description="Post management")
@RequestMapping("/api/auth")
public class PostController {

    private PostServiceImpl postService;

    private UserRepository userRepository;

    @Autowired
    public PostController(PostServiceImpl postService,UserRepository userRepository) {
        this.postService = postService;
        this.userRepository = userRepository;
    }

    @SecurityRequirement(name = "JWT")
    @Operation(
            summary = "Create new post",
            description = "User can add post"
    )
    @PostMapping("/createPost")
    public ResponseEntity<String> savePost(@RequestBody PostDto postDto,
                                           @AuthenticationPrincipal UserDetails userDetails){

        User user = userRepository.findByUsername(userDetails.getUsername());
        postService.createPost(postDto, user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @SecurityRequirement(name = "JWT")
    @Operation(
            summary = "Get All posts",
            description = "User can get all posts"
    )
    @GetMapping("/posts")
    private List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @SecurityRequirement(name = "JWT")
    @Operation(
            summary = "Update post",
            description = "User can update his own post"
    )
    @PutMapping("/post/{id}")
    private ResponseEntity<String> updatePost(@PathVariable("id") long id,@RequestBody PostDto postDto, @AuthenticationPrincipal UserDetails userDetails) {
        String message = postService.updatePost(postDto, id, userDetails.getUsername());
        return ResponseEntity.ok(message);
    }

    @SecurityRequirement(name = "JWT")
    @Operation(
            summary = "Delete post",
            description = "User can delete his own post"
    )
    @DeleteMapping("/post/{id}")
    private ResponseEntity<String> deletePost(@PathVariable("id") long id, @AuthenticationPrincipal UserDetails userDetails) {
        String message = postService.deletePostById(id, userDetails.getUsername());
        return ResponseEntity.ok(message);
    }

}
