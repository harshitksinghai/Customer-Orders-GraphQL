package com.example.Customer_Orders_GraphQL.Repositories;

import com.example.Customer_Orders_GraphQL.Models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
