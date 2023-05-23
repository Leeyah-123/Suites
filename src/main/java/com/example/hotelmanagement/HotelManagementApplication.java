package com.example.hotelmanagement;

import com.example.hotelmanagement.models.CategoryType;
import com.example.hotelmanagement.models.Role;
import com.example.hotelmanagement.models.Room;
import com.example.hotelmanagement.models.User;
import com.example.hotelmanagement.services.RoomService;
import com.example.hotelmanagement.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class HotelManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotelManagementApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    CommandLineRunner run(UserService userService, RoomService roomService) {
//        return args -> {
//            userService.saveRole(new Role(null, "USER"));
//            userService.saveRole(new Role(null, "EMPLOYEE"));
//            userService.saveRole(new Role(null, "ADMIN"));
//
//            userService.saveUser(new User("", "Assad", "Junaid", "c@c.com", "Test@password", new ArrayList<>()));
//            userService.saveUser(new User("", "Aisha", "Junaid", "b@b.com", "Test@password", new ArrayList<>()));
//            userService.saveUser(new User("", "Aaliyah", "Junaid", "a@a.com", "Test@password", new ArrayList<>()));
//
//            userService.addUserRole("c@c.com", "USER");
//
//            userService.addUserRole("b@b.com", "USER");
//            userService.addUserRole("b@b.com", "EMPLOYEE");
//
//            userService.addUserRole("a@a.com", "USER");
//            userService.addUserRole("a@a.com", "EMPLOYEE");
//            userService.addUserRole("a@a.com", "ADMIN");
//
//            roomService.saveRoom(new Room(null, "Room 001", "My first standard room", 3, "/images/hotel1.jpg", 4000.00, CategoryType.STANDARD));
//            roomService.saveRoom(new Room(null, "Room 002", "My second standard room", 4, "/images/hotel2.jpg", 5000.00, CategoryType.STANDARD));
//            roomService.saveRoom(new Room(null, "Room 003", "My third standard room", 5, "/images/hotel3.jpg", 6000.00, CategoryType.STANDARD));
//
//            roomService.saveRoom(new Room(null, "Room 004", "My first family room", 9, "/images/hotel4.jpg", 4000.00, CategoryType.FAMILY));
//            roomService.saveRoom(new Room(null, "Room 005", "My second family room", 11, "/images/hotel5.jpg", 5000.00, CategoryType.FAMILY));
//            roomService.saveRoom(new Room(null, "Room 006", "My third family room", 13, "/images/hotel6.jpg", 6000.00, CategoryType.FAMILY));
//
//            roomService.saveRoom(new Room(null, "Room 007", "My first deluxe room", 1, "/images/hotel7.jpg", 4000.00, CategoryType.DELUXE));
//            roomService.saveRoom(new Room(null, "Room 008", "My second deluxe room", 3, "/images/hotel8.jpg", 5000.00, CategoryType.DELUXE));
//            roomService.saveRoom(new Room(null, "Room 009", "My third deluxe room", 2, "/images/hotel4.jpg", 6000.00, CategoryType.DELUXE));
//        };
//    }

}
