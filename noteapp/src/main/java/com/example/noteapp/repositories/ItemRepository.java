package com.example.noteapp.repositories;

import com.example.noteapp.entities.Item;
import com.example.noteapp.entities.Note;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    Iterable<Item> findItemsByNote(Note note, Sort sort);
    Item findItemByItemId(int id);
    void deleteItemsByNote(Note note);
    void deleteItemByItemId(int id);
}
