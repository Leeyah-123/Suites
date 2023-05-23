package com.example.hotelmanagement.repositories;

import com.example.hotelmanagement.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, String> {
    User findByEmail(String email);
}
