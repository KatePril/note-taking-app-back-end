package com.example.noteapp.controllers;

import com.example.noteapp.entities.User;
import com.example.noteapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{username}")
    public ResponseEntity<?> getUser(@PathVariable String username) {
        try {
            return ResponseEntity.ok(userService.getUser(username));
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(-1);
        }
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable int userId) {
        try {
            return ResponseEntity.ok(userService.getUserById(userId));
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/password/{userId}")
    public ResponseEntity<?> getPasswordById(@PathVariable int userId) {
        try {
            return ResponseEntity.ok(userService.getUserById(userId).getPassword());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user) {
        try {
            return ResponseEntity.ok(userService.createOrUpdateUser(user));
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(-1);
        }
    }

    @PutMapping("/username")
    public ResponseEntity<?> updateUsername(@RequestBody User updatedUser) {
        try {
            User user = userService.getUserById(updatedUser.getUserId());
            user.setUsername(updatedUser.getUsername());
            return ResponseEntity.ok(userService.createOrUpdateUser(user));
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @PutMapping("/password")
    public ResponseEntity<?> updatePassword(@RequestBody User updatedUser) {
        try {
            User user = userService.getUserById(updatedUser.getUserId());
            user.setPassword(updatedUser.getPassword());
            return ResponseEntity.ok(userService.updatePassword(user));
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(-1);
        }
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable int userId) {
        try {
            userService.deleteUser(userId);
            return ResponseEntity.ok().build();
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }
}
