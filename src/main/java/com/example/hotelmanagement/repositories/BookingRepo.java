package com.example.hotelmanagement.repositories;

import com.example.hotelmanagement.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface BookingRepo extends JpaRepository<Booking, String> {
    List<Booking> findAllByUserId(String userId);
    List<Booking> findAllByDate(Date date);
}
