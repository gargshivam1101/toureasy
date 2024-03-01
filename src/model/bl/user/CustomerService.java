package model.bl.user;

import java.util.List;

import model.bl.booking.BookingService;
import model.entity.Booking;
import model.entity.User;

public class CustomerService extends UserService {

    public static List<Booking> getAllMyBookings(User loggedInUser) {
        return BookingService.getBookingsByCustomer(loggedInUser.getEmail());
    }

    public static void deleteMyBooking(String bookingId) {
        BookingService.cancelBooking(bookingId);
    }

    public static void createNewBooking(User loggedInUser, String tourId, String status, String paymentStatus) {
        BookingService.createBooking(loggedInUser.getEmail(), tourId, status, paymentStatus);
    }
}
