package com.example.hotelmanagement.controllers.client;

import com.example.hotelmanagement.models.CategoryType;
import com.example.hotelmanagement.models.Room;
import com.example.hotelmanagement.repositories.RoomRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ClientController {
    private final RoomRepo roomRepo;

    @GetMapping ("/")
    public String index() {
        return "client/index.html";
    }

    @GetMapping ("/rooms")
    public String rooms(Model model) {
        List<Room> standardRooms = roomRepo.findAllByCategoryType(CategoryType.STANDARD);
        List<Room> familyRooms = roomRepo.findAllByCategoryType(CategoryType.FAMILY);
        List<Room> deluxeRooms = roomRepo.findAllByCategoryType(CategoryType.DELUXE);

        model.addAttribute("standardRooms", standardRooms);
        model.addAttribute("familyRooms", familyRooms);
        model.addAttribute("deluxeRooms", deluxeRooms);

        return "client/rooms.html";
    }

    @GetMapping ("/room/{id}")
    public String room(Model model, @PathVariable("id") String id) {
        Optional<Room> room = roomRepo.findById(id);

        if (room.isPresent()) {
            model.addAttribute("room", room.get());
            return "client/room.html";
        } else return "error.html";
    }

    @GetMapping("/bookings")
    public String bookings(Model model) {
        return "client/bookings.html";
    }

}
