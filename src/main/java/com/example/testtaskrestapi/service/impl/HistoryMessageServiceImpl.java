package com.example.testtaskrestapi.service.impl;

import com.example.testtaskrestapi.model.HistoryMessage;
import com.example.testtaskrestapi.repository.HistoryMessageRepository;
import com.example.testtaskrestapi.service.HistoryMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryMessageServiceImpl implements HistoryMessageService {

    private HistoryMessageRepository messageRepository;

    @Autowired
    public HistoryMessageServiceImpl(HistoryMessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public List<HistoryMessage> getMessageHistory(long sender_id, long recipient_id) {
        return messageRepository.findMessageHistory(sender_id, recipient_id);
    }
}
