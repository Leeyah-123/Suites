package com.example.hotelmanagement.services;

import com.example.hotelmanagement.models.Role;
import com.example.hotelmanagement.models.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addUserRole(String email, String roleName);
    User getUser(String email);
    List<User> getUsers();
}
