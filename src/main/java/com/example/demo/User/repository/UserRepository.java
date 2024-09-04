package com.example.demo.User.repository;

import com.example.demo.User.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository{

    List<User> findByUserId(String userid);

    boolean existByUserId(String userid);

    boolean existByUserIdAndPassword(String userid, String password);

    User save(User user);


}
