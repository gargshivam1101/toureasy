package model.bl.user;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import controller.user.AdminController;
import controller.user.CustomerController;
import controller.user.GuideController;
import model.entity.User;
import model.enums.KnownLanguages;
import model.enums.Role;

public class UserService {

	static List<User> userList = new ArrayList<>(Arrays.asList(//
			new User("Shivam", "Garg", LocalDateTime.of(1999, 1, 11, 13, 0), "4387701101", "gs@gmail.com",
					new ArrayList<>(Arrays.asList(KnownLanguages.ENGLISH, KnownLanguages.PUNJABI)), "pass", Role.GUIDE), //
			new User("Tu", "Mu", null, "123", "tumu@gmail.com", null, "pass", Role.CUSTOMER), //
			new User("S", "G", null, "11111", "admin@gmail.com", null, "pass", Role.ADMINISTRATOR)//
	));

	public static List<User> getUserList() {
		return userList;
	}

	public static void putUserList(User user) {
		userList.add(user);
	}
	
	public static void removeUserList(User user) {
		userList.remove(user);
	}
	
	protected static User getUserByEmail(String email) {
		return userList.stream().filter(u -> email.equalsIgnoreCase(u.getEmail()))
				.findFirst().orElse(null);
	}

	public static User login(String email, String password) {

		User loggedInUser = getUserList().stream()
				.filter(user -> user.getEmail().equals(email) && user.getPassword().equals(password)).findFirst()
				.orElse(null);

		if (loggedInUser == null) {
			System.out.println("Sorry, you have entered wrong credentials!");
			return null;
		}

		// Authenticated user
		System.out.println("Welcome " + loggedInUser.getFirstName());
		if (Role.GUIDE.equals(loggedInUser.getRole())) {
			GuideController.processUserInput(loggedInUser);
		} else if (Role.CUSTOMER.equals(loggedInUser.getRole())) {
			CustomerController.processUserInput(loggedInUser);
		} else if (Role.ADMINISTRATOR.equals(loggedInUser.getRole())) {
			AdminController.processUserInput(loggedInUser);
		}
		return loggedInUser;
	}

	public static void logout() {
		System.out.println("You have been successfully logged out");
	}

	public static void showProfile(User loggedInUser) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");

		System.out.println("First Name: " + loggedInUser.getFirstName());
		System.out.println("Last Name: " + loggedInUser.getLastName());
		System.out.println("Date of Birth: "
				+ (loggedInUser.getDob() != null ? loggedInUser.getDob().format(formatter) : "Unknown"));
		System.out.println("Contact Number: " + loggedInUser.getContactNo());
		System.out.println("Email: " + loggedInUser.getEmail());
		System.out.println("Known Languages: ");
		if (loggedInUser.getKnownLanguages() != null) {
			for (KnownLanguages language : loggedInUser.getKnownLanguages()) {
				System.out.println("\t- " + language);
			}
		} else {
			System.out.println("\t- None");
		}
		System.out.println("Role: " + loggedInUser.getRole());
	}

	public static void editProfile(User loggedInUser, String contactNo, List<KnownLanguages> knownLanguages) {
		loggedInUser.setContactNo(contactNo);
		loggedInUser.setKnownLanguages(knownLanguages);
		System.out.println("The profile information has been updated successfully");
	}
}
