package com.example.noteapp.services;

import com.example.noteapp.entities.Note;
import com.example.noteapp.entities.User;
import com.example.noteapp.repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteService {
    private final NoteRepository noteRepository;

    @Autowired
    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public Iterable<Note> getNotesByUser(User user) {
        return noteRepository.findNotesByUser(user);
    }

    public Note getNoteById(int id) {
        return noteRepository.findNoteByNoteId(id);
    }

    public Note createOrUpdateNote(Note note) {
        return noteRepository.save(note);
    }

    public Note deleteNoteById(int id) {
        return noteRepository.deleteNoteByNoteId(id);
    }
}
