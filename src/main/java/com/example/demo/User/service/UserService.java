package com.example.demo.User.service;

import com.example.demo.User.repository.UserRepository;
import com.example.demo.User.domain.User;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
public class UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findByUserId(String userid) {
        return userRepository.findByUserId(userid);
    }

    public List<User> UserPre(String userid) {
        List<User> user = userRepository.findByUserId(userid);
        user.forEach(us -> log.info("Food found: {}", us.toString()));
        return userRepository.findByUserId(userid);
    }

    public User user_create(User user) {
        userRepository.save(user);
        return user;
    }

    public boolean user_existByUserId(String userid) {
        return userRepository.existByUserId(userid);
    }

    public boolean user_existByUserIdAndPassword(String userid, String password) {
        return userRepository.existByUserIdAndPassword(userid, password);
    }



}
