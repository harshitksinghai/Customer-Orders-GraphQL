package com.example.Customer_Orders_GraphQL.Controllers;

import com.example.Customer_Orders_GraphQL.Models.User;
import com.example.Customer_Orders_GraphQL.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @MutationMapping
    public User createUser(@Argument String email, @Argument String password, @Argument String name, @Argument String phone){
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setName(name);
        user.setPhone(phone);
        return userService.createUser(user);
    }

    @QueryMapping(name = "getAllUsers")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @QueryMapping
    public User getUser(@Argument long userId){
        return userService.getUser(userId);
    }

    @SchemaMapping(typeName = "Mutation", field = "deleteUser")
    public boolean deleteUser(@Argument long userId){
        return userService.deleteUser(userId);
    }
}
