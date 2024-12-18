package com.example.noteapp.repositories;

import com.example.noteapp.entities.Note;
import com.example.noteapp.entities.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
    Iterable<Note> findNotesByUser(User user, Sort sort);
    Note findNoteByNoteId(int id);
    void deleteNoteByNoteId(int id);
}
