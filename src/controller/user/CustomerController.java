package controller.user;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import model.bl.booking.BookingService;
import model.bl.payment.PaymentService;
import model.bl.user.CustomerService;
import model.bl.user.UserService;
import model.entity.Booking;
import model.entity.PaymentInfo;
import model.entity.User;
import model.enums.KnownLanguages;
import view.users.CustomerView;
import view.users.UserView;

public class CustomerController {
	public static void processUserInput(User loggedInUser) {
		boolean isLoggedIn = true;
		while (isLoggedIn) {
			int choice = CustomerView.showMenuAndChoose();
			switch (choice) {
				case 0:
					LoginController.logout();
					isLoggedIn = false;
					break;
				case 1:
					UserService.showProfile(loggedInUser);
					break;
				case 2:
					UserView.promptToEditProfile(loggedInUser);
					String contactNo = UserView.getContactNoInput();
					List<KnownLanguages> knownLanguages = UserView.getKnownLanguagesInput();
					UserService.editProfile(loggedInUser, contactNo, knownLanguages);
					break;
				case 3:
					List<Booking> myBookings = CustomerService.getAllMyBookings(loggedInUser);
					CustomerView.displayAllMyBookings(myBookings);
					break;
				case 4:
					String bookingId = CustomerView.promptForBookingId();
					CustomerService.deleteMyBooking(bookingId);
					System.out.println("Booking canceled successfully.");
					break;
				case 5:
					String tourId = CustomerView.promptForTourId();
					String status = CustomerView.promptForBookingStatus();

					// New payment integration
					PaymentInfo paymentInfo = CustomerService.createPaymentInfo();
					boolean paymentSuccessful = PaymentService.processPayment(paymentInfo);

					if (paymentSuccessful) {
						String specialRequest = CustomerView.promptForSpecialRequest();
						BookingService.createBooking(tourId, loggedInUser.getEmail(), new Date(), paymentInfo);
						System.out.println("Booking created successfully.");
					} else {
						System.out.println("Payment failed. Booking not created.");
					}
					break;
				default:
					System.out.println("Invalid choice!");
			}
		}
	}
}