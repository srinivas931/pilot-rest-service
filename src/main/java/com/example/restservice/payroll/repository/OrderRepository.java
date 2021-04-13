package com.example.restservice.payroll.repository;

import com.example.restservice.payroll.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
