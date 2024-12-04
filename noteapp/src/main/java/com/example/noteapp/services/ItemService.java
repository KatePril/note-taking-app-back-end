package com.example.noteapp.services;

import com.example.noteapp.entities.Item;
import com.example.noteapp.entities.Note;
import com.example.noteapp.repositories.ItemRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Iterable<Item> getItemsByNote(Note note) {
        return itemRepository.findItemsByNote(note, Sort.by(Sort.Order.asc("itemId")));
    }

    public Item getItemById(int id) {
        return itemRepository.findItemByItemId(id);
    }

    public Item createOrUpdateItem(Item item) {
        return itemRepository.save(item);
    }

    @Transactional
    public void deleteItemById(int id) {
        itemRepository.deleteItemByItemId(id);
    }
}
