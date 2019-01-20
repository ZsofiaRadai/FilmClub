package com.mybusiness.filmclub.service;

import com.mybusiness.filmclub.db.model.User;
import com.mybusiness.filmclub.db.repository.UserRepository;
import com.mybusiness.filmclub.dto.CreateUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Base64;
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
        user.setPassword(passwordEncoder.encode(createUserRequest.getPassword()));
        user.setEmail(createUserRequest.getEmail());
        user.setUsername(createUserRequest.getUsername());
        return userRepository.save(user);
    }

    public User login(String credentials) throws Exception {
        String[] splitCredentials = decodeAndSplitCredentials(credentials);
        String email = splitCredentials[0];
        String password = splitCredentials[1];
        User userByEmail;
        try {
            userByEmail = userRepository.findByEmail(email);
        } catch (Exception e) {
            throw new Exception("Could not connect to database.");
        }
        if (passwordEncoder.matches(password, userByEmail.getPassword())) {
            return userByEmail;
        } else {
            throw new Exception("Wrong username or password.");
        }
    }

    private String[] decodeAndSplitCredentials(String credentials) {
        byte[] decodedCredentials = Base64.getDecoder().decode(credentials);
        String decodedString = new String(decodedCredentials);
        String[] splitCredentials = decodedString.split(":");
        return splitCredentials;
    }
}
