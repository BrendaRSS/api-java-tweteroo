package com.tweteroo.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dtos.TweetDTO;
import com.tweteroo.api.models.TweetModel;
import com.tweteroo.api.services.TweetService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/tweets")
public class TweetController {

    final TweetService tweetService;

    TweetController(TweetService tweetService){
        this.tweetService = tweetService;
    }

    @PostMapping
    public ResponseEntity<Object> createTweet(@RequestBody @Valid TweetDTO body){
        Optional<TweetModel> tweet = tweetService.save(body);

        if(!tweet.isPresent()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The user does nnot exist");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(tweet);
    }

    @GetMapping
    public ResponseEntity<List<TweetModel>> getTweets(){
        List<TweetModel> tweets = tweetService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(tweets);
    }

    @GetMapping("/user/{authorId}")
    public ResponseEntity<Object> getTweetByAuthorId(@PathVariable Long authorId){
        List<TweetModel> tweets = tweetService.finByAuthorId(authorId);
        return ResponseEntity.status(HttpStatus.OK).body(tweets);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTweet(@PathVariable Long id){
        tweetService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
