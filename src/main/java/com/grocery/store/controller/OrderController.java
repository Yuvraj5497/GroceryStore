package com.grocery.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.grocery.store.entities.MyOrder;
import com.grocery.store.service.OrderService;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/bookorder")
    public MyOrder createOrder(@RequestBody List<Integer> groceryIds) {
        return orderService.createOrder(groceryIds);
    }

}
