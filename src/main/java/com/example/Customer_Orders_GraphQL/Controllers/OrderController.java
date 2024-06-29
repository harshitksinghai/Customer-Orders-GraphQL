package com.example.Customer_Orders_GraphQL.Controllers;

import com.example.Customer_Orders_GraphQL.Models.Order;
import com.example.Customer_Orders_GraphQL.Models.User;
import com.example.Customer_Orders_GraphQL.Services.OrderService;
import com.example.Customer_Orders_GraphQL.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class OrderController {
    @Autowired
    OrderService orderService;

    @Autowired
    UserService userService;
    @MutationMapping
    public Order createOrder(@Argument String orderDetails, @Argument String address, @Argument int price, @Argument long userId){
        Order order = new Order();
        order.setOrderDetails(orderDetails);
        order.setAddress(address);
        order.setPrice(price);
        User user = new User();

        userService.getUser(userId);
        order.setUser(user);
        return orderService.createOrder(order);
    }

    @QueryMapping
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }

    @QueryMapping
    public Order getOrder(@Argument long orderId){
        return orderService.getOrder(orderId);
    }

    @MutationMapping
    public boolean deleteOrder(@Argument long orderId){
        return orderService.deleteOrder(orderId);
    }
}
