package com.grocery.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grocery.store.entities.MyOrder;

@Repository
public interface OrderRepository extends JpaRepository<MyOrder, Integer> {

}
