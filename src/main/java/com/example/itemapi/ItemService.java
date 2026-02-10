package com.example.itemapi;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Service class for managing items in-memory using ArrayList.
 * Provides methods to add a new item and retrieve an item by ID.
 */
@Service
public class ItemService {

    private final List<Item> items = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1); // Auto-generate IDs starting from 1

    /**
     * Adds a new item to the collection.
     * Auto-generates a unique ID for the item.
     * @param item The item to add (without ID).
     * @return The added item with generated ID.
     */
    public Item addItem(Item item) {
        item.setId(idGenerator.getAndIncrement());
        items.add(item);
        return item;
    }

    /**
     * Retrieves an item by its ID.
     * @param id The ID of the item to retrieve.
     * @return An Optional containing the item if found, or empty if not.
     */
    public Optional<Item> getItemById(Long id) {
        return items.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst();
    }

    /**
     * Retrieves all items (for potential future use).
     * @return List of all items.
     */
    public List<Item> getAllItems() {
        return new ArrayList<>(items);
    }
}
