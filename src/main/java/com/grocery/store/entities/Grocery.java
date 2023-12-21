package com.grocery.store.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Grocery {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)    
    private int id;
    private String name;
    private int price;
    private int inventoryLevel;    
}