package com.example.hotelmanagement.implementations;

import com.example.hotelmanagement.models.Booking;
import com.example.hotelmanagement.repositories.BookingRepo;
import com.example.hotelmanagement.services.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor @Transactional
public class BookingServiceImplementation implements BookingService {
    private final BookingRepo bookingRepo;

    @Override
    public Booking saveBooking(Booking booking) {
        return bookingRepo.save(booking);
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepo.findAll();
    }

    @Override
    public Optional<Booking> getBooking(String id) {
        return bookingRepo.findById(id);
    }

    @Override
    public List<Booking> getBookingsByUserId(String userId) {
        return bookingRepo.findAllByUserId(userId);
    }

    @Override
    public List<Booking> getBookingsByDate(Date date) {
        return bookingRepo.findAllByDate(date);
    }

    @Override
    public Booking updateBooking(Booking booking) {
        return bookingRepo.save(booking);
    }

    @Override
    public void deleteBookingById(String id) {
        bookingRepo.deleteById(id);
    }
}
