package com.mybusiness.filmclub.service;

import com.mybusiness.filmclub.configuration.PasswordEncoder;
import com.mybusiness.filmclub.db.model.User;
import com.mybusiness.filmclub.db.repository.UserRepository;
import com.mybusiness.filmclub.dto.CreateUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User createUser(CreateUserRequest createUserRequest) {
        User user = new User();
        user.setPassword(passwordEncoder.BCyptPasswordEncoder().encode(createUserRequest.getPassword()));
        user.setEmail(createUserRequest.getEmail());
        user.setUsername(createUserRequest.getUsername());
        return userRepository.save(user);
    }

    public User login(String credentials) {
        return userRepository.findByEmail(credentials);
    }
}
