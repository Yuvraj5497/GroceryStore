package com.grocery.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.grocery.store.entities.Grocery;
import com.grocery.store.service.GroceryService;

@RestController
public class GroceryController {

    @Autowired
    private GroceryService groceryService;

    @PostMapping("/grocery")
    public Grocery addGrocery(@RequestBody Grocery grocery) {
        return groceryService.addGrocery(grocery);
    }

    @GetMapping("/groceries")
    public List<Grocery> getAllGroceries() {
        return groceryService.getAllGroceries();
    }

    @GetMapping("/groceries/{groceryId}")
    public Grocery getGrocery(@PathVariable int groceryId) {
        return groceryService.getGrocery(groceryId);
    }

    @DeleteMapping("/grocery/{groceryId}")
    public void deleteGrocery(@PathVariable int groceryId) {
        groceryService.deleteGrocery(groceryId);
    }

    @PutMapping("/grocery/{groceryId}")
    public Grocery updateGrocery(@PathVariable int groceryId, @RequestBody Grocery grocery) {
        return groceryService.updateGrocery(groceryId, grocery);
    }

    @PutMapping("/grocery/inventorylevel/{groceryId}")
    public Grocery addInventory(@PathVariable int groceryId, @RequestBody Grocery grocery) {
        return groceryService.addInventory(groceryId, grocery);
    }

}
