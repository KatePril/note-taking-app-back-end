package com.example.noteapp.services;

import com.example.noteapp.entities.User;
import com.example.noteapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    public Integer createUser(User user) throws Exception {
        if (userRepository.existsUserByUsername(user.getUsername())) {
            throw new Exception("User with provided username already exists");
        } else {
            return userRepository.save(user).getUserId();
        }
    }

    public User getUser(String username) {
        return userRepository.findUserByUsername(username);
    }

    public User getUserById(Integer userId) {
        return userRepository.findUserByUserId(userId);
    }
}
