package com.example.hotelmanagement.services;

import com.example.hotelmanagement.models.Booking;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface BookingService {
    Booking saveBooking(Booking booking);
    List<Booking> getAllBookings();
    Optional<Booking> getBooking(String id);
    List<Booking> getBookingsByUserId(String userId);
    List<Booking> getBookingsByDate(Date date);
    Booking updateBooking(Booking booking);
    void deleteBookingById(String id);
}
