package model.bl.booking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import model.entity.Booking;

public class BookingService {

    // Assume this list is populated with some initial bookings
    static List<Booking> bookingList = new ArrayList<>(Arrays.asList(
            new Booking("B001", "T001", "C001", new Date(), "Confirmed", "Paid"),
            new Booking("B002", "T002", "C002", new Date(), "Confirmed", "Pending")
    ));

    public static List<Booking> getAllBookings() {
        return bookingList;
    }

    public static Booking getBookingById(String bookingId) {
        return bookingList.stream().filter(booking -> booking.getBookingID().equals(bookingId)).findFirst().orElse(null);
    }

    public static List<Booking> getBookingsByCustomer(String customerId) {
        return bookingList.stream().filter(booking -> booking.getCustomerID().equals(customerId)).collect(Collectors.toList());
    }

    public static List<Booking> getBookingsByTour(String tourId) {
        return bookingList.stream().filter(booking -> booking.getTourID().equals(tourId)).collect(Collectors.toList());
    }

    public static void updateBooking(String bookingId, String tourId, Date date, String status, String paymentStatus) {
        Booking booking = getBookingById(bookingId);
        if (booking != null) {
            booking.setTourID(tourId);
            booking.setDate(date);
            booking.setStatus(status);
            booking.setPaymentStatus(paymentStatus);
            System.out.println("Booking details updated successfully.");
        } else {
            System.out.println("Booking not found.");
        }
    }

    public static void cancelBooking(String bookingId) {
        Booking booking = getBookingById(bookingId);
        if (booking != null) {
            booking.setStatus("Cancelled");
            System.out.println("Booking cancelled successfully.");
        } else {
            System.out.println("Booking not found.");
        }
    }
}
