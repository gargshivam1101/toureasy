package model.bl.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import model.bl.booking.BookingService;
import model.entity.*;
import model.enums.PaymentMode;
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
		PaymentInfo paymentInfo = createPaymentInfo();
		BookingService.createBooking(tourId, loggedInUser.getEmail(), new Date(), paymentInfo);
	};

	public static PaymentInfo createPaymentInfo(){
		String billingName = promptForBillingName();
		String billingAddress = promptForBillingAddress();
		PaymentMode preferredModeOfPayment = promptForPaymentMode();

		if (preferredModeOfPayment == PaymentMode.CARD) {
			String cardDetails = promptForCardDetails();
			return new PaymentInfo(billingName, billingAddress, PaymentMode.CARD, null, cardDetails);
		} else if (preferredModeOfPayment == PaymentMode.WALLET) {
			// For wallet payment, you may need additional logic
			Wallet walletDetails = promptForWalletDetails();
			return new PaymentInfo(billingName, billingAddress, PaymentMode.WALLET, walletDetails, null);
		} else {
			return null;
		}
	}

	private static String promptForBillingName() {
		return "Adam Lord";
	}

	private static String promptForBillingAddress() {
		return "123 Main St";
	}

	private static PaymentMode promptForPaymentMode() {
		return PaymentMode.CARD;
	}

	private static String promptForCardDetails() {
		return "1234-5678-9012-3456"; // Replace with actual user input
	}

	private static Wallet promptForWalletDetails() {
		String walletId = "W001"; // Replace with actual user input or generation logic
		double walletBalance = 100.0; // Replace with actual user input or initialization
		return new Wallet(walletId, walletBalance);
	}
}
