package com.example.Customer_Orders_GraphQL.Services.Impl;

import com.example.Customer_Orders_GraphQL.Models.User;
import com.example.Customer_Orders_GraphQL.Repositories.UserRepository;
import com.example.Customer_Orders_GraphQL.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public User createUser(User user){
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @Override
    public User getUser(long userId){
        return userRepository.findById(userId).orElseThrow(()->new RuntimeException("User not found in db"));
    }

    @Override
    public boolean deleteUser(long userId){
        User user = userRepository.findById(userId).orElseThrow(()->new RuntimeException("User not found in db"));
        userRepository.delete(user);
        return true;
    }
}
