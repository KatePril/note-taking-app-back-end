package com.example.noteapp.entities;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id", nullable = false)
    private Long itemId;

    @Column
    private String header;

    @Column
    private String text;

    @Column
    @Lob
    private byte[] image;

    @Column
    @Lob
    private byte[] canvas;

    @Column(columnDefinition = "jsonb")
    private String offsets;

    @ManyToOne
    @JoinColumn(name = "note_id", nullable = false)
    private Note note;

}
