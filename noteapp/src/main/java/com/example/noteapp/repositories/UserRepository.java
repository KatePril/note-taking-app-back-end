package com.example.noteapp.repositories;

import com.example.noteapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsUserByUsername(String username);
    User findUserByUsername(String username);
    User findUserByUserId(int userId);
    void deleteUserByUserId(int userId);
}
