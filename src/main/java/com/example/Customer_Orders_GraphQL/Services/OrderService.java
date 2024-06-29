package com.example.Customer_Orders_GraphQL.Services;

import com.example.Customer_Orders_GraphQL.Models.Order;

import java.util.List;

public interface OrderService {
    Order createOrder(Order order);

    List<Order> getAllOrders();

    Order getOrder(long orderId);

    boolean deleteOrder(long orderId);
}
