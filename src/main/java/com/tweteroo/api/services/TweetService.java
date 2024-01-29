package com.tweteroo.api.services;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tweteroo.api.dtos.TweetDTO;
import com.tweteroo.api.models.TweetModel;
import com.tweteroo.api.models.UserModel;
import com.tweteroo.api.repositories.TweetRepository;
import com.tweteroo.api.repositories.UserRepository;

@Service
public class TweetService {

    final UserRepository userRepository;
    final TweetRepository tweetRepository;

    TweetService(UserRepository userRepository, TweetRepository tweetRepository){
        this.userRepository = userRepository;
        this.tweetRepository = tweetRepository;
    }

    public Optional<TweetModel> save(TweetDTO bodyDto){
        Optional<UserModel> user = userRepository.findById(bodyDto.getAuthorId());

        if(!user.isPresent()){
            return Optional.empty();
        }

        TweetModel tweet = new TweetModel(bodyDto, user.get());
        return Optional.of(tweetRepository.save(tweet));

    }
}
