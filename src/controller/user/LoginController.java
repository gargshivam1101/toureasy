package controller.user;

import model.bl.user.UserService;
import model.entity.User;

public class LoginController {
	public static User login(String email, String password) {
	    return UserService.login(email, password);
	}
}
