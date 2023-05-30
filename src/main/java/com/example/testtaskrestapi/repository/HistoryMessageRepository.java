package com.example.testtaskrestapi.repository;

import com.example.testtaskrestapi.model.HistoryMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryMessageRepository extends JpaRepository<HistoryMessage, Long> {

    @Query(value = "SELECT * FROM history_message m WHERE m.sender_id = :sender_id and m.recipient_id = :recipient_id or m.sender_id = :recipient_id and m.recipient_id = :sender_id ORDER BY date_time DESC",
    nativeQuery = true)
    List<HistoryMessage> findMessageHistory (
            @Param("sender_id") long sender_id,
            @Param("recipient_id") long recipient_id
    );
}
