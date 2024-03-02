package model.bl.user;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import model.bl.booking.BookingService;
import model.entity.Booking;
import model.entity.Customer;
import model.entity.User;
import model.enums.Role;

public class CustomerService extends UserService {

	static List<Customer> customerList = new ArrayList<>();

	public static List<Customer> getCustomerList() {
		return UserService.getUserList().stream().filter(u -> u.getRole().equals(Role.CUSTOMER))
				.map(u -> new Customer(u, "Toronto", null)).collect(Collectors.toList());
	}

	public static List<Booking> getAllMyBookings(User loggedInUser) {
		return BookingService.getBookingsByCustomer(loggedInUser.getEmail());
	}

	public static void deleteMyBooking(String bookingId) {
		BookingService.cancelBooking(bookingId);
	}

	public static void createNewBooking(User loggedInUser, String tourId, String status, String paymentStatus,
			String specialRequest) {
		BookingService.createBooking(loggedInUser.getEmail(), tourId, status, paymentStatus, specialRequest);
	}
}
