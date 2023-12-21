package com.grocery.store.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grocery.store.entities.Grocery;
import com.grocery.store.entities.MyOrder;
import com.grocery.store.repository.GroceryRepository;
import com.grocery.store.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private GroceryRepository groceryRepository;

    public MyOrder createOrder(List<Integer> groceryIds) {
        MyOrder order = new MyOrder();
        List<Grocery> groceries = new ArrayList<>();
        for (Integer groceryId : groceryIds) {
            Optional<Grocery> groceryOptional = groceryRepository.findById(groceryId);
            Grocery grocery = groceryOptional.get();
            grocery.setInventoryLevel(grocery.getInventoryLevel() - 1);
            groceries.add(grocery);
        }
        order.setGroceries(groceries);
        orderRepository.save(order);
        groceryRepository.saveAll(groceries);
        return order;
    }

}
