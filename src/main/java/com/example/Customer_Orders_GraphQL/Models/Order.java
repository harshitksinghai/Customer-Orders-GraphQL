package com.example.Customer_Orders_GraphQL.Models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private String orderDetails;

    private String address;

    private int price;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
