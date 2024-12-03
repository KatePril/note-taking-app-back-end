package com.example.noteapp.services;

import com.example.noteapp.entities.User;
import com.example.noteapp.repositories.UserRepository;
import jakarta.transaction.Transactional;
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

    public int createOrUpdateUser(User user) throws Exception {
        if (userRepository.existsUserByUsername(user.getUsername())) {
            throw new Exception("User with provided username already exists");
        } else {
            return userRepository.save(user).getUserId();
        }
    }

    public User getUser(String username) {
        return userRepository.findUserByUsername(username);
    }

    public User getUserById(int userId) {
        return userRepository.findUserByUserId(userId);
    }

    @Transactional
    public void deleteUser(int id) {
        userRepository.deleteUserByUserId(id);
    }
}
