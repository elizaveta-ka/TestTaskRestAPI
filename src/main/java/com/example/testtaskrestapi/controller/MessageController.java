package com.example.testtaskrestapi.controller;

import com.example.testtaskrestapi.model.HistoryMessage;
import com.example.testtaskrestapi.repository.UserRepository;
import com.example.testtaskrestapi.service.impl.HistoryMessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class MessageController {

    private HistoryMessageServiceImpl historyMessageService;

    private UserRepository userRepository;


    @Autowired
    public MessageController(HistoryMessageServiceImpl historyMessageService, UserRepository userRepository) {
        this.historyMessageService = historyMessageService;
        this.userRepository = userRepository;
    }

    @GetMapping("/history/{id}")
    public List<HistoryMessage> getMessageHistory(@PathVariable("id") long recipient_id, @AuthenticationPrincipal User sender) {
        com.example.testtaskrestapi.model.User user = userRepository.findByUsername(sender.getUsername());
        return historyMessageService.getMessageHistory(user.getId(), recipient_id);
    }
}
