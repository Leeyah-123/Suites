package com.example.hotelmanagement.api;

import com.example.hotelmanagement.models.CategoryType;
import com.example.hotelmanagement.models.Room;
import com.example.hotelmanagement.services.RoomService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController()
@RequestMapping("/api")
@RequiredArgsConstructor
public class RoomController {
    private final RoomService roomService;

    @GetMapping("/rooms")
    public ResponseEntity<List<Room>> getRooms() {
        return ResponseEntity.ok().body(roomService.getAllRooms());
    }

    @GetMapping("/room/{id}")
    public ResponseEntity<Optional<Room>> getRoomById(@PathVariable("id") String id) {
        return ResponseEntity.ok().body(roomService.getRoom(id));
    }

    @PostMapping("/rooms")
    public ResponseEntity<Room> addRoom(AddRoomForm form) {
        CategoryType categoryType;
        switch (form.getCategory()) {
            case "STANDARD":
                categoryType = CategoryType.STANDARD;
                break;
            case "FAMILY":
                categoryType = CategoryType.FAMILY;
                break;
            case "DELUXE":
                categoryType = CategoryType.DELUXE;
                break;
            default:
                return ResponseEntity.badRequest().body(null);
        }

        Room room = new Room(null, form.getName(), form.getDescription(), form.getNumberAvailable(), form.getRoomImg(), form.getPrice(), categoryType);
        return ResponseEntity.ok().body(roomService.saveRoom(room));
    }

    @PatchMapping("/room/{id}")
    public ResponseEntity<Room> updateRoomById(@PathVariable("id") String id) {
        Optional<Room> room = roomService.getRoom(id);

        room.ifPresent(roomService::updateRoom);
        return ResponseEntity.ok().body(roomService.getRoom(id).get());
    }

    @DeleteMapping("/room/{id}")
    public ResponseEntity<Map<String, String>> deleteRoomById(@PathVariable("id") String id) {
        Optional<Room> room = roomService.getRoom(id);

        room.ifPresent(roomService::updateRoom);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Room deleted successfully");
        return ResponseEntity.ok().body(response);
    }
}

@Data
class AddRoomForm {
    private String name;
    private String description;
    private int numberAvailable;
    private String roomImg;
    private Double price;
    private String category;
}
