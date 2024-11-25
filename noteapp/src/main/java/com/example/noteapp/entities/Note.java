package com.example.noteapp.entities;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "note")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "note_id", nullable = false)
    private Long noteId;

    @Column
    private String title;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
