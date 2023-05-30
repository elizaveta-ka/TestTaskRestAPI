package com.example.testtaskrestapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "history_message")
public class HistoryMessage {

    @Id
    private long message_id;

    private long sender_id;

    private long recipient_id;

    private String text;

    private Date dateTime;

    private MessageStatus status;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinColumn(name = "sender_id", insertable = false, updatable = false)
    private User sender;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinColumn(name = "recipient_id", insertable = false, updatable = false)
    private User recipient;

    @Override
    public String toString() {
        return "HistoryMessage{" +
                "message_id=" + message_id +
                ", sender_id=" + sender_id +
                ", recipient_id=" + recipient_id +
                ", text='" + text + '\'' +
                ", dateTime=" + dateTime +
                ", status=" + status +
                ", sender=" + sender +
                ", recipient=" + recipient +
                '}';
    }
}
