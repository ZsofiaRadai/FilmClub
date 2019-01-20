package com.mybusiness.filmclub.controller;

import com.mybusiness.filmclub.db.model.User;
import com.mybusiness.filmclub.dto.CreateUserRequest;
import com.mybusiness.filmclub.dto.LoginUserResponse;
import com.mybusiness.filmclub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200")
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

    @GetMapping("/login")
    public LoginUserResponse login(@RequestHeader(value="authorization") String credentials) throws Exception {
        User user = userService.login(credentials);
        LoginUserResponse userResponse = new LoginUserResponse();
        userResponse.setEmail(user.getEmail());
        userResponse.setUsername(user.getUsername());
        return userResponse;
    }

}
