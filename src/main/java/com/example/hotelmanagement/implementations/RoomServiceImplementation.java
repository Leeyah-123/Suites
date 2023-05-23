package com.example.hotelmanagement.implementations;

import com.example.hotelmanagement.models.CategoryType;
import com.example.hotelmanagement.models.Room;
import com.example.hotelmanagement.repositories.RoomRepo;
import com.example.hotelmanagement.services.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class RoomServiceImplementation implements RoomService {
    private final RoomRepo roomRepo;

    @Override
    public Room saveRoom(Room room) {
        return roomRepo.save(room);
    }

    @Override
    public Optional<Room> getRoom(String id) {
        return roomRepo.findById(id);
    }

    @Override
    public List<Room> getRoomsByCategory(CategoryType categoryType) {
        return roomRepo.findAllByCategoryType(categoryType);
    }

    @Override
    public List<Room> getAllRooms() {
        return roomRepo.findAll();
    }

    @Override
    public Room updateRoom(Room room) {
       return roomRepo.save(room);
    }

    @Override
    public void deleteRoomById(String id) {
        roomRepo.deleteById(id);
    }
}
