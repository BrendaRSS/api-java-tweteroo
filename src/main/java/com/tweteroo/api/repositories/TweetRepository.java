package com.tweteroo.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tweteroo.api.models.TweetModel;

@Repository
public interface TweetRepository extends JpaRepository<TweetModel, Long>{
    @Query(value =  "SELECT t.id as id, t.text as text, t.author_id as author_id FROM tweets t\n" + //
        "JOIN users u ON t.author_id = u.id\n" + //
        "WHERE u.id = :authorId", nativeQuery = true)
    List<TweetModel> findByAuthorId(@Param("authorId") Long authorId);

}
