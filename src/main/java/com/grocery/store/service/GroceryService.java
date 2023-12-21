package com.grocery.store.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grocery.store.entities.Grocery;
import com.grocery.store.repository.GroceryRepository;

@Service
public class GroceryService {

    @Autowired
    private GroceryRepository groceryRepository;

    public Grocery addGrocery(Grocery grocery) {
        return groceryRepository.save(grocery);
    }

    public List<Grocery> getAllGroceries() {
        return groceryRepository.findAll();
    }

    public Grocery getGrocery(int groceryId) {
        return groceryRepository.findById(groceryId).get();
    }

    public void deleteGrocery(int groceryId) {
        groceryRepository.deleteById(groceryId);
    }

    public Grocery updateGrocery(int groceryId, Grocery grocery) {
        Optional<Grocery> grocerydb = groceryRepository.findById(groceryId);
        if (grocerydb.isPresent()) {
            Grocery grocery2 = grocerydb.get();
            grocery2.setName(grocery.getName());
            grocery2.setPrice(grocery.getPrice());
            return groceryRepository.save(grocery2);
        }
        return null;
    }

    public Grocery addInventory(int groceryId, Grocery grocery) {
        Optional<Grocery> grocerydb = groceryRepository.findById(groceryId);
        if (grocerydb.isPresent()) {
            Grocery grocery2db = grocerydb.get();
            grocery2db.setInventoryLevel(grocery2db.getInventoryLevel() + grocery.getInventoryLevel());
            return groceryRepository.save(grocery2db);
        }
        return null;
    }

}
