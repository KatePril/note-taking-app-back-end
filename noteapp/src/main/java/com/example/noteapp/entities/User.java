package com.example.noteapp.entities;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "app_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false, unique = true)
    private int userId;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;
}
