package controller.user;

import java.util.List;

import model.bl.user.CustomerService;
import model.bl.user.UserService;
import model.entity.Booking;
import model.entity.User;
import model.enums.KnownLanguages;
import view.users.CustomerView;
import view.users.UserView;

public class CustomerController {

	public static void processUserInput(User loggedInUser) {
		Boolean isLoggedIn = true;
		while (isLoggedIn) {
			int choice = CustomerView.showMenuAndChoose(loggedInUser);
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
					String paymentStatus = CustomerView.promptForBookingPaymentStatus();
					CustomerService.createNewBooking(loggedInUser, tourId, status, paymentStatus);
					System.out.println("Booking created successfully.");
					break;
				default:
					System.out.println("Invalid choice!");
			}

		}
	}

}
