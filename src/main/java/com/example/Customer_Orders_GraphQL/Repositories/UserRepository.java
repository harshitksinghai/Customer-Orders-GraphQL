package com.example.Customer_Orders_GraphQL.Repositories;

import com.example.Customer_Orders_GraphQL.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
