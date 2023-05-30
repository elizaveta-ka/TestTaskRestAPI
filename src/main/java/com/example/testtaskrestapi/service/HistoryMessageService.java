package com.example.testtaskrestapi.service;

import com.example.testtaskrestapi.model.HistoryMessage;

import java.util.List;

public interface HistoryMessageService {

    List<HistoryMessage> getMessageHistory (long sender_id, long recipient_id);

}
