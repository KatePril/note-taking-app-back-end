package com.example.noteapp.controllers;

import com.example.noteapp.entities.Item;
import com.example.noteapp.entities.Note;
import com.example.noteapp.services.ItemService;
import com.example.noteapp.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/items")
public class ItemController {
    private ItemService itemService;
    private NoteService noteService;

    @Autowired
    public ItemController(ItemService itemService, NoteService noteService) {
        this.itemService = itemService;
        this.noteService = noteService;
    }

    @GetMapping("/{noteId}")
    public ResponseEntity<?> getItem(@PathVariable int noteId) {
        try {
            Note note = noteService.getNoteById(noteId);
            return ResponseEntity.ok(itemService.getItemsByNote(note));
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> createItem(@RequestBody Item item) {
        try {
            return ResponseEntity.ok(itemService.createOrUpdateItem(item));
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<?> updateItem(@RequestBody Item item) {
        try {
            return ResponseEntity.ok(itemService.createOrUpdateItem(item));
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }
}
