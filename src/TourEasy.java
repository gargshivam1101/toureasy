import model.entity.User;
import model.enums.Role;
import view.login.LoginView;

import model.bl.tour.TourService;
import view.tour.TourView;
import controller.tour.TourController;


import model.bl.booking.BookingService;
import view.booking.BookingView;
import controller.booking.BookingController;

import java.util.Scanner;


public class TourEasy {
	public static void main(String[] args) {

        TourService tourService = new TourService();
        TourView tourView = new TourView();
        TourController tourController = new TourController(tourService, tourView);
        BookingService bookingService = new BookingService();  // You need to implement the BookingService class
        BookingView bookingView = new BookingView();
        BookingController bookingController = new BookingController(bookingService, bookingView);


        int choice;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("======= TEST CONSOLE MENU ========");
            System.out.println("1. Booking");
            System.out.println("2. Tour");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    bookingController.processUserInput();
                    break;
                case 2:
                    tourController.processUserInput();
                    break;
                case 3:
                    System.out.println("Exiting TEST CONSOLE MENU.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 3);


//		while (true) {
//			User loggedInUser = LoginView.login();
//			if (loggedInUser == null) {
//				continue;
//			}
//
//			// Authenticated user
//			if (Role.GUIDE.equals(loggedInUser.getRole())) {
//				System.out.println("Hi guide");
//			} else if (Role.CUSTOMER.equals(loggedInUser.getRole())) {
//				System.out.println("Hello customer");
//
//			}
//		}

    }
}