package model.bl.booking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import model.bl.tour.TourService;
import model.entity.Booking;
import model.entity.SpecialRequest;
import model.entity.Tour;

public class BookingService {

	// Assume this list is populated with some initial bookings
	static List<Booking> bookingList = new ArrayList<>(
			Arrays.asList(new Booking("B001", "T001", "C001", new Date(), "Confirmed", "Paid", null),
					new Booking("B002", "T002", "C002", new Date(), "Confirmed", "Pending", null)));

	public static List<Booking> getAllBookings() {
		return bookingList;
	}

	public static Booking getBookingById(String bookingId) {
		return bookingList.stream().filter(booking -> booking.getBookingID().equals(bookingId)).findFirst()
				.orElse(null);
	}

	public static List<Booking> getBookingsByCustomer(String customerId) {
		return bookingList.stream().filter(booking -> booking.getCustomerID().equals(customerId))
				.collect(Collectors.toList());
	}

	public static List<Booking> getBookingsByTour(String tourId) {
		return bookingList.stream().filter(booking -> booking.getTourID().equals(tourId)).collect(Collectors.toList());
	}

	public static void createBooking(String customerEmail, String tourId, String status, String paymentStatus,
			String specialRequest) {
		// Check if the tour exists
		Tour tour = TourService.getTourById(tourId);
		if (tour != null) {
			// Generate a unique booking ID
			String bookingId = UUID.randomUUID().toString();

			// Get current date and time
			Date currentDate = new Date();

			// Make SpecialRequest
			SpecialRequest spRequestObj = new SpecialRequest(false, specialRequest);

			// Create a new booking
			Booking booking = new Booking(bookingId, tourId, customerEmail, currentDate, status, paymentStatus,
					spRequestObj);

			// Add the booking to the list
			bookingList.add(booking);

			System.out.println("Booking created successfully.");
		} else {
			System.out.println("Tour not found. Cannot create booking.");
		}
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
