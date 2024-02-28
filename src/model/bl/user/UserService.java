package model.bl.user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.entity.User;
import model.enums.Role;

public class UserService {
	static User loggedInUser = null;

	static List<User> userList = new ArrayList<>(Arrays.asList(//
			new User("Shivam", "Garg", null, "4387791101", "gs@gmail.com", null, "wc", Role.CUSTOMER), //
			new User("Tushar", "Mukker", null, "12345", "tm@gmail.com", null, "pass", Role.GUIDE)//
	));

	public static List<User> getUserList() {
		return userList;
	}

	public static void putUserList(User user) {
		userList.add(user);
	}

	public static User login(String email, String password) {

		User lgInUser = getUserList().stream()
				.filter(user -> user.getEmail().equals(email) && user.getPassword().equals(password)).findFirst()
				.orElse(null);

		if (lgInUser == null) {
			System.out.println("Sorry, you have entered wrong credentials!");
			return null;
		}

		loggedInUser = lgInUser;

		System.out.println("Welcome " + lgInUser.getFirstName());
		System.out.println("You have been successfully logged in");
		return lgInUser;
	}
}
