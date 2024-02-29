package controller.user;

import java.time.LocalDateTime;
import java.util.List;

import model.bl.user.AdminService;
import model.entity.User;
import model.enums.KnownLanguages;
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
			default:
				System.out.println("Invalid!");
			}

		}
	}

}
