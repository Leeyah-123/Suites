package com.example.hotelmanagement.repositories;

import com.example.hotelmanagement.models.CategoryType;
import com.example.hotelmanagement.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepo extends JpaRepository<Room, String> {
    List<Room> findAllByCategoryType(CategoryType categoryType);
}
