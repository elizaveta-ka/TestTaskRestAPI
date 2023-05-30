package com.example.testtaskrestapi.controller;

import com.example.testtaskrestapi.model.User;
import com.example.testtaskrestapi.repository.UserRepository;
import com.example.testtaskrestapi.security.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class SubscriberController {
    private UserRepository userRepository;

    private CustomUserDetailsService userService;

    @Autowired
    public SubscriberController(UserRepository userRepository, CustomUserDetailsService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @PostMapping("/subscribe/{id}")
    public ResponseEntity<String> subscribeUser(@PathVariable("id") long id, @AuthenticationPrincipal UserDetails userDetails) {
        User currentUser = userRepository.findByUsername(userDetails.getUsername());
        User user = userRepository.getById(id);
        userService.subscribe(currentUser,user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/unsubscribe/{id}")
    public ResponseEntity<String> unsubscribeUser(@PathVariable("id") long id, @AuthenticationPrincipal UserDetails userDetails) {
        User currentUser = userRepository.findByUsername(userDetails.getUsername());
        User user = userRepository.getById(id);
        userService.unsubscribe(currentUser,user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/approveApp/{id}")
    public ResponseEntity<String> addAsFriends(@PathVariable("id") long id, @AuthenticationPrincipal UserDetails userDetails) {
        User currentUser = userRepository.findByUsername(userDetails.getUsername());
        User user = userRepository.getById(id);
        if (currentUser.getSubscribers().contains(user)) {
            userService.addAsFriend(currentUser, user);
            userService.subscribe(currentUser,user);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/deleteFriend/{id}")
    public ResponseEntity<String> removeFromFriends(@PathVariable("id") long id, @AuthenticationPrincipal UserDetails userDetails) {
        User currentUser = userRepository.findByUsername(userDetails.getUsername());
        User user = userRepository.getById(id);
        userService.removeFromFriends(currentUser,user);
        userService.unsubscribe(currentUser, user);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
