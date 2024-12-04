package com.example.noteapp.services;

import com.example.noteapp.entities.Note;
import com.example.noteapp.entities.User;
import com.example.noteapp.repositories.ItemRepository;
import com.example.noteapp.repositories.NoteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteService {
    private final NoteRepository noteRepository;
    private final ItemRepository itemRepository;


    @Autowired
    public NoteService(NoteRepository noteRepository, ItemRepository itemRepository) {
        this.noteRepository = noteRepository;
        this.itemRepository = itemRepository;
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

    @Transactional
    public void deleteNoteById(int id) {
        Note note = noteRepository.findNoteByNoteId(id);
        itemRepository.deleteItemsByNote(note);
        noteRepository.deleteNoteByNoteId(id);
    }
}
