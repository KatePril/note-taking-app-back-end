package com.example.noteapp.controllers;

import com.example.noteapp.entities.Note;
import com.example.noteapp.entities.User;
import com.example.noteapp.services.ItemService;
import com.example.noteapp.services.NoteService;
import com.example.noteapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/notes")
public class NoteController {
    private final NoteService noteService;
    private final UserService userService;
    private final ItemService itemService;

    @Autowired
    public NoteController(NoteService noteService, UserService userService, ItemService itemService) {
        this.noteService = noteService;
        this.userService = userService;
        this.itemService = itemService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getNotes(@PathVariable int userId) {
        try {
            User user = userService.getUserById(userId);
            return ResponseEntity.ok(noteService.getNotesByUser(user));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/note/{noteId}")
    public ResponseEntity<?> getNoteById(@PathVariable int noteId) {
        try {
            return ResponseEntity.ok(noteService.getNoteById(noteId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> createNote(@RequestBody Note note) {
        try {
            return ResponseEntity.ok(noteService.createOrUpdateNote(note));
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<?> updateNote(@RequestBody Note note) {
        try {
            return ResponseEntity.ok(noteService.createOrUpdateNote(note));
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @DeleteMapping("/{noteId}")
    public ResponseEntity<?> deleteNote(@PathVariable int noteId) {
        try {
            Note note = noteService.getNoteById(noteId);
            itemService.deleteItemsByNote(note);
            noteService.deleteNoteById(noteId);
            return ResponseEntity.ok().build();
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }
}
