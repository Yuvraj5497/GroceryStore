package com.grocery.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grocery.store.entities.Grocery;

@Repository
public interface GroceryRepository extends JpaRepository<Grocery, Integer> {

}
