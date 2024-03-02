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
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter billing name: ");
		String input = scanner.nextLine();
		return input.trim();
	}

	private static String promptForBillingAddress() {
		 Scanner scanner = new Scanner(System.in);
		 System.out.print("Enter billing address: ");
		 String input = scanner.nextLine();
		 return input.trim();
	}

	private static PaymentMode promptForPaymentMode() {
		PaymentMode paymentMode = null;
		boolean validInput = false;
		Scanner scanner = new Scanner(System.in);

		do {
			System.out.print("Choose payment mode (CARD, WALLET): ");
			String userInput = scanner.nextLine().toUpperCase();

			try {
				paymentMode = PaymentMode.valueOf(userInput);
				validInput = true;
			} catch (IllegalArgumentException e) {
				System.out.println("Invalid input. Please enter a valid payment mode.");
			}
		} while (!validInput);

		return paymentMode;
	}

	private static String promptForCardDetails() {
		 Scanner scanner = new Scanner(System.in);
		 System.out.print("Enter card number: ");
		 return scanner.nextLine();
	}

	static Wallet promptForWalletDetails() {
		String walletId = "W001"; // Replace with actual user input or generation logic
		double walletBalance = 100.0; // Replace with actual user input or initialization
		return new Wallet(walletId, walletBalance);
	}
}
