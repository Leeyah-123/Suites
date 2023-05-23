package com.example.hotelmanagement.api;

import com.example.hotelmanagement.models.Booking;
import com.example.hotelmanagement.models.StatusType;
import com.example.hotelmanagement.services.BookingService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BookingController {
    private final BookingService bookingService;

    @GetMapping("/bookings")
    public ResponseEntity<List<Booking>> getBookings() {
        return ResponseEntity.ok().body(bookingService.getAllBookings());
    }

    @GetMapping("/bookings/id/{id}")
    public ResponseEntity<Optional<Booking>> getBookingById(@PathVariable("id") String id) {
        return ResponseEntity.ok().body(bookingService.getBooking(id));
    }

    @GetMapping("/booking/date/{date}")
    public ResponseEntity<List<Booking>> getBookingsByDate(@PathVariable("date") Date date) {
        return ResponseEntity.ok().body(bookingService.getBookingsByDate(date));
    }

    @GetMapping("/booking/userId/{userId}")
    public ResponseEntity<List<Booking>> getBookingsByUserId(@PathVariable("userId") String userId) {
        return ResponseEntity.ok().body(bookingService.getBookingsByUserId(userId));
    }

    @PostMapping("/bookings")
    public ResponseEntity<Booking> addBooking(@RequestBody() AddBookingForm form) {
        Booking booking = new Booking("", form.getUserId(), form.getRoomId(), form.getDate(), StatusType.PENDING);
        return ResponseEntity.ok().body(bookingService.saveBooking(booking));
    }

    @PatchMapping("/bookings/{id}")
    public ResponseEntity<Booking> updateBooking(@PathVariable("id") String id, @RequestBody() UpdateBookingForm form) {
        Optional<Booking> booking = bookingService.getBooking(id);

        if (booking.isEmpty()) return ResponseEntity.badRequest().body(null);

        StatusType statusType;
        switch (form.getStatus()) {
            case "PENDING":
                statusType = StatusType.PENDING;
                break;
            case "EXPIRED":
                statusType = StatusType.EXPIRED;
                break;
            case "CANCELLED":
                statusType = StatusType.CANCELLED;
                break;
            case "CHECKED_OUT":
                statusType = StatusType.CHECKED_OUT;
                break;
            default:
                return ResponseEntity.badRequest().body(null);
        }

        booking.get().setUserId(form.getUserId());
        booking.get().setRoomId(form.getRoomId());
        booking.get().setDate(form.getDate());
        booking.get().setStatusType(statusType);

        return ResponseEntity.ok().body(bookingService.updateBooking(booking.get()));
    }
}

@Data
class AddBookingForm {
    private String userId;
    private String roomId;
    private Date date;
}

@Data
class UpdateBookingForm {
    private String userId;
    private String roomId;
    private Date date;
    private String status;
}
