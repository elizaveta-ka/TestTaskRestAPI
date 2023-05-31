package com.example.testtaskrestapi.controller;

import com.example.testtaskrestapi.dto.PostDto;
import com.example.testtaskrestapi.model.Post;
import com.example.testtaskrestapi.model.User;
import com.example.testtaskrestapi.repository.UserRepository;
import com.example.testtaskrestapi.service.PostService;
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

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
@Tag(name="Post Controller", description="Post management")
@RequestMapping("/api/auth")
public class PostController {

    private PostService postService;

    private UserRepository userRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(PostController.class);

    public PostController(PostService postService,UserRepository userRepository) {
        this.postService = postService;
        this.userRepository = userRepository;
    }

    @SecurityRequirement(name = "JWT")
    @Operation(
            summary = "Create new post",
            description = "User can add post"
    )
    @PostMapping("/createPost")
    public ResponseEntity<String> savePost(@RequestBody @Valid PostDto postDto,
                                           BindingResult bindingResult,
                                           @AuthenticationPrincipal UserDetails userDetails){
        if(bindingResult.hasErrors()) {
            System.out.println(bindingResult.hasErrors());
            return new ResponseEntity<>("Not valid parameters", HttpStatus.BAD_REQUEST);
        }

        User user = userRepository.findByUsername(userDetails.getUsername());
        postService.createPost(postDto, user);
        LOGGER.debug("Received comment: {}", postDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @SecurityRequirement(name = "JWT")
    @Operation(
            summary = "Get All Controller",
            description = "User can get all posts"
    )
    @GetMapping("/posts")
    private List<Post> getAllQuotes() {
        return postService.getAllPosts();
    }

    @SecurityRequirement(name = "JWT")
    @Operation(
            summary = "Update Post Controller",
            description = "User can update his own post"
    )
    @PutMapping("post/{id}")
    private ResponseEntity<String> updatePost(@PathVariable("id") long id,@RequestBody PostDto postDto, @AuthenticationPrincipal UserDetails userDetails) {
        String message = postService.updatePost(postDto, id, userDetails.getUsername());
        return ResponseEntity.ok(message);
    }

    @SecurityRequirement(name = "JWT")
    @Operation(
            summary = "Delete Post Controller",
            description = "User can delete his own post"
    )
    @DeleteMapping("post/{id}")
    private ResponseEntity<String> deletePost(@PathVariable("id") long id, @AuthenticationPrincipal UserDetails userDetails) {
        String message = postService.deletePostById(id, userDetails.getUsername());
        return ResponseEntity.ok(message);
    }

}
