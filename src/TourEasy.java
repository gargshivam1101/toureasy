import controller.booking.BookingController;
import controller.tour.TourController;
import controller.user.LoginController;
import model.bl.booking.BookingService;
import model.bl.tour.TourService;
import model.entity.User;
import view.booking.BookingView;
import view.tour.TourView;


public class TourEasy {
	public static void main(String[] args) {

        TourService tourService = new TourService();
        TourView tourView = new TourView();
        TourController tourController = new TourController(tourService, tourView);
        BookingService bookingService = new BookingService();  // You need to implement the BookingService class
        BookingView bookingView = new BookingView();
        BookingController bookingController = new BookingController(bookingService, bookingView);


//        int choice;
//        do {
//            Scanner scanner = new Scanner(System.in);
//            System.out.println("======= TEST CONSOLE MENU ========");
//            System.out.println("1. Booking");
//            System.out.println("2. Tour");
//            System.out.println("3. Exit");
//            System.out.print("Enter your choice: ");
//
//            choice = scanner.nextInt();
//
//            switch (choice) {
//                case 1:
//                    bookingController.processUserInput();
//                    break;
//                case 2:
//                    tourController.processUserInput();
//                    break;
//                case 3:
//                    System.out.println("Exiting TEST CONSOLE MENU.");
//                    break;
//                default:
//                    System.out.println("Invalid choice. Please try again.");
//            }
//
//        } while (choice != 3);


		while (true) {
			User loggedInUser = LoginController.login();

		}

    }
}