package com.example.Customer_Orders_GraphQL.Services.Impl;

import com.example.Customer_Orders_GraphQL.Models.Order;
import com.example.Customer_Orders_GraphQL.Repositories.OrderRepository;
import com.example.Customer_Orders_GraphQL.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public Order createOrder(Order order){
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    @Override
    public Order getOrder(long orderId){
        return orderRepository.findById(orderId).orElseThrow(()->new RuntimeException("Order not found in db"));
    }
    @Override
    public boolean deleteOrder(long orderId){
        Order order = orderRepository.findById(orderId).orElseThrow(()->new RuntimeException("Order not found in db"));
        orderRepository.delete(order);
        return true;
    }
}
