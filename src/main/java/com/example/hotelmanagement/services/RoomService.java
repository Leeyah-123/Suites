package com.example.hotelmanagement.services;

import com.example.hotelmanagement.models.CategoryType;
import com.example.hotelmanagement.models.Room;

import java.util.List;
import java.util.Optional;

public interface RoomService {
    Room saveRoom(Room room);
    Optional<Room> getRoom(String id);
    List<Room> getRoomsByCategory(CategoryType categoryType);
    List<Room> getAllRooms();
    Room updateRoom(Room room);
    void deleteRoomById(String id);
}
