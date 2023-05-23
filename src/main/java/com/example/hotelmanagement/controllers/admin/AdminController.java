package com.example.hotelmanagement.controllers.admin;

import com.example.hotelmanagement.repositories.BookingRepo;
import com.example.hotelmanagement.repositories.RoomRepo;
import com.example.hotelmanagement.repositories.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class AdminController {
    private final RoomRepo roomRepo;
    private final BookingRepo bookingRepo;
    private final UserRepo userRepo;

    @GetMapping ("/admin")
    public String index(Model model) {
        model.addAttribute("roomCount", roomRepo.findAll().size());
        model.addAttribute("bookingCount", bookingRepo.findAll().size());
        model.addAttribute("userCount", userRepo.findAll().size());

        return "admin/index.html";
    }

    @GetMapping("/admin/add-room")
    public String addRoom() {
        return "admin/add-room.html";
    }

    @GetMapping("/admin/rooms")
    public String viewRooms(Model model) {
        model.addAttribute("rooms", roomRepo.findAll());
        return "admin/rooms.html";
    }

    @GetMapping("/admin/bookings")
    public String viewBookings(Model model) {
        model.addAttribute("bookings", bookingRepo.findAll());
        return "admin/bookings.html";
    }

    @GetMapping("/admin/users")
    public String viewUsers(Model model) {
        model.addAttribute("users", userRepo.findAll());
        return "admin/users.html";
    }
}
