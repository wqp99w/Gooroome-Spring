package com.example.demo.User.controller;


import com.example.demo.User.service.UserService;
import com.example.demo.User.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/preferences")
    public List<User> findById(String userid) {
        return userService.findByUserId(userid);
    }

    @GetMapping("/existsId")
    public boolean checkUserExists(String userid) {
        return  userService.user_existByUserId(userid);
    }

    @GetMapping("/Login")
    public boolean checkLogin(String userid,String password) {
        return  userService.user_existByUserIdAndPassword(userid, password);
    }

    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
        return userService.user_create(user);
    }


}

