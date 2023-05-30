package com.example.testtaskrestapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    private Set<Role> roles;

    @ManyToMany
    @JsonIgnore
    @JoinTable(
            name = "user_subscriptions",
            joinColumns = { @JoinColumn(name = "channel_id") },
            inverseJoinColumns = { @JoinColumn(name = "subscriber_id") }
    )
    private Set<User> subscribers = new HashSet<>();

    @ManyToMany
    @JsonIgnore
    @JoinTable(
            name = "user_subscriptions",
            joinColumns = { @JoinColumn(name = "subscriber_id") },
            inverseJoinColumns = { @JoinColumn(name = "channel_id") }
    )
    private Set<User> subscriptions = new HashSet<>();

    @ManyToMany
    @JsonIgnore
    @JoinTable(
            name = "friend_channels",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "friend_id") }
    )
    private Set<User> friends = new HashSet<>();

    @ManyToMany
    @JsonIgnore
    @JoinTable(
            name = "friend_channels",
            joinColumns = { @JoinColumn(name = "friend_id") },
            inverseJoinColumns = { @JoinColumn(name = "user_id") }
    )
    private Set<User> friends_app = new HashSet<>();

    @OneToMany(mappedBy = "sender", fetch = FetchType.EAGER)
    @JsonIgnore
    @Fetch(value = FetchMode.SUBSELECT)
    private Collection<HistoryMessage> senders;

    @OneToMany(mappedBy = "recipient", fetch = FetchType.EAGER)
    @JsonIgnore
    @Fetch(value = FetchMode.SUBSELECT)
    private Collection<HistoryMessage> recipients;

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                '}';
    }

    //    @OneToMany(mappedBy = "friend",
//            orphanRemoval = true,
//            cascade = CascadeType.ALL)
//    private Set<Friend> friends = new HashSet<>();
//
//
//    @OneToMany(mappedBy = "channel",
//            orphanRemoval = true,
//            cascade = CascadeType.ALL)
//    private Set<Friend> channels = new HashSet<>();

}
