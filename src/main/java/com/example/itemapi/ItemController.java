package com.example.itemapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.Optional;

/**
 * REST Controller for managing items.
 * Provides endpoints to add a new item and retrieve an item by ID.
 */
@RestController
@Validated
public class ItemController {

    @Autowired
    private ItemService itemService;

    /**
     * Welcome endpoint - confirms API is running.
     * @return API status message.
     */
    @GetMapping("/")
    public ResponseEntity<String> welcome() {
        return new ResponseEntity<>("Item API is running! Use POST /items to add items and GET /items/{id} to retrieve them.", HttpStatus.OK);
    }

    /**
     * Adds a new item.
     * Validates the input and returns the added item with generated ID.
     * @param item The item to add (JSON body).
     * @return ResponseEntity with the added item or error.
     */
    @PostMapping("/items")
    public ResponseEntity<Item> addItem(@Valid @RequestBody Item item) {
        Item addedItem = itemService.addItem(item);
        return new ResponseEntity<>(addedItem, HttpStatus.CREATED);
    }

    /**
     * Retrieves an item by its ID.
     * @param id The ID of the item.
     * @return ResponseEntity with the item if found, or 404 if not.
     */
    @GetMapping("/items/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable Long id) {
        Optional<Item> item = itemService.getItemById(id);
        if (item.isPresent()) {
            return new ResponseEntity<>(item.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
