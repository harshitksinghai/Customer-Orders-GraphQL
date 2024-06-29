package com.example.Customer_Orders_GraphQL.Services;

import com.example.Customer_Orders_GraphQL.Models.User;

import java.util.List;

public interface UserService {
    User createUser(User user);

    List<User> getAllUsers();

    User getUser(long userId);

    boolean deleteUser(long userId);
}
