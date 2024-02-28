//import model.entity.User;
//import model.enums.Role;
//import view.login.LoginView;
import view.tour.TourView;
import controller.tour.TourController;
import model.bl.tour.TourService;

public class TourEasy {
	public static void main(String[] args) {

		TourService tourService = new TourService();
		TourView tourView = new TourView();
		TourController tourController = new TourController(tourService, tourView);


		tourController.processUserInput();

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