package controller.user;

import java.time.LocalDateTime;
import java.util.List;

import model.bl.user.AdminService;
import model.entity.User;
import model.enums.KnownLanguages;
import model.enums.ModeOfTransport;
import model.enums.Role;
import view.users.AdminView;
import view.users.UserView;

public class AdminController {

	public static void processUserInput(User loggedInUser) {
		Boolean isLoggedIn = true;
		while (isLoggedIn) {
			int choice = AdminView.showMenuAndChoose(loggedInUser);
			switch (choice) {
			case 0:
				LoginController.logout();
				isLoggedIn = false;
				break;
			case 1:
				AdminService.showAllUsers();
				break;
			case 2:
				AdminView.promptToAddUser();
				String firstName = AdminView.getFirstNameInput();
				String lastName = AdminView.getLastNameInput();
				LocalDateTime dob = AdminView.getDateOfBirthInput();
				String contactNo = UserView.getContactNoInput();
				String email = AdminView.getEmailInput();
				List<KnownLanguages> knownLanguages = UserView.getKnownLanguagesInput();
				Role role = AdminView.getRoleInput();
				AdminService.addUser(firstName, lastName, dob, contactNo, email, knownLanguages, role);
				break;
			case 3:
				AdminView.promptToRemoveUser();
				String emailToRemove = AdminView.getEmailInput();
				AdminService.removeUser(emailToRemove);
				break;
			case 5:
				// view hotels
				AdminService.showAllHotels();
				break;
			case 6:
				// add hotels
				AdminView.promptToAddHotel();
				String hotelName = AdminView.getHotelNameInput();
				String hotelAddress = AdminView.getHotelAddressInput();
				String cityName = AdminView.getCityNameInput();
				Integer noOfAvailRooms = AdminView.getNoOfRoomsInp();
				Float price = AdminView.getPriceInp();
				String mfirstName = AdminView.getFirstNameInput();
				String mlastName = AdminView.getLastNameInput();
				LocalDateTime mdob = AdminView.getDateOfBirthInput();
				String mcontactNo = UserView.getContactNoInput();
				String memail = AdminView.getEmailInput();
				List<KnownLanguages> mknownLanguages = UserView.getKnownLanguagesInput();
				AdminService.addHotel(hotelName, hotelAddress, cityName, noOfAvailRooms, price, mfirstName, mlastName,
						mdob, mcontactNo, memail, mknownLanguages);
				break;
			case 7:
				AdminService.showAllTours();
				break;
			case 8:
				// will use pre existing guide by asking for email uuid
				// will use pre existing hotel by hotel id
				AdminView.promptToAddTour();
				String tourId = AdminView.getTourIdInput();
				String destination = AdminView.getDestinationInput();
				Integer numberOfNights = AdminView.getNoOfNightsInput();
				Integer hotelId = AdminView.getHotelIdInput();
				ModeOfTransport modeofTransport = AdminView.getModeOfTransportInput();
				String guideEmail = AdminView.getGuideEmailInput();
				AdminService.addTour(tourId, destination, numberOfNights, hotelId, modeofTransport, guideEmail);
				break;
			default:
				System.out.println("Invalid!");
			}

		}
	}

}
