package controller.user;

import model.bl.user.UserService;
import model.entity.User;
import view.login.LoginView;

public class LoginController {

	public static User login() {
		String email = LoginView.getUserNameInput();
		String pwd = LoginView.getPasswordInput();
		User loggedInUser = UserService.login(email, pwd);
		if (loggedInUser == null) {
			return login();
		}
		return loggedInUser;
	}

	public static void logout() {
		UserService.logout();
		login();
	}
}
