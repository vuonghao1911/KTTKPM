package com.example.spring_lap_5.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring_lap_5.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
