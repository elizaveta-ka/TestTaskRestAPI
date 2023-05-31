package com.example.testtaskrestapi.repository;

import com.example.testtaskrestapi.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    @Query(value = "SELECT * FROM posts JOIN user_subscriptions WHERE user_id = channel_id and subscriber_id = :subscriber_id ORDER BY date_post DESC",
            nativeQuery = true)
    Page<Post> findLastPostsSubscribers (@Param("subscriber_id") long subscriber_id, Pageable pageable);
}
