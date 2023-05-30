//package com.example.testtaskrestapi.model;
//
//import com.fasterxml.jackson.annotation.*;
//import jakarta.persistence.*;
//import lombok.*;
//
//import java.io.Serializable;
//
//@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Setter
//@Getter
//public class Friend implements Serializable {
//
//    @EmbeddedId
//    @JsonIgnore
//    @Column(name = "key")
//    private FriendKey key;
//
//    @MapsId("friendId")
//    @ManyToOne
//    @JsonIdentityReference
//    @JsonIdentityInfo(
//            property = "id",
//            generator = ObjectIdGenerators.PropertyGenerator.class
//    )
//    private User friend;
//
//    @MapsId("channelId")
//    @ManyToOne
//    @JsonIdentityReference
//    @JsonIdentityInfo(
//            property = "id",
//            generator = ObjectIdGenerators.PropertyGenerator.class
//    )
//    private User channel;
//
//    private int status;
//
//}
