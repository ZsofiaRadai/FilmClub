package com.mybusiness.filmclub.controller;

import com.mybusiness.filmclub.db.model.User;
import com.mybusiness.filmclub.dto.CreateUserRequest;
import com.mybusiness.filmclub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {
        return userService.getAll();
    }

    @PostMapping("/createUser")
    public User createUser(@RequestBody CreateUserRequest createUserRequest) {
        return userService.createUser(createUserRequest);
    }

    @PostMapping("/login")
    public User login(@RequestHeader String credentials) {
        User login = userService.login(credentials);
        return login;
    }
}
