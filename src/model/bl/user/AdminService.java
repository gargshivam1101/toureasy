package model.bl.user;

import java.time.LocalDateTime;
import java.util.List;

import model.entity.User;
import model.enums.KnownLanguages;
import model.enums.Role;

public class AdminService extends UserService {

	public static void showAllUsers() {
		userList.forEach(u -> {
			showProfile(u);
			System.out.println();
		});
	}

	public static void addUser(String firstName, String lastName, LocalDateTime dob, String contactNo, String email,
			List<KnownLanguages> knownLanguages, Role role) {
		User user = new User(firstName, lastName, dob, contactNo, email, knownLanguages, email, role);
		putUserList(user);
		System.out.println("The user has been added");
	}

	public static void removeUser(String email) {
		User userToRemove = getUserByEmail(email);
		removeUserList(userToRemove);
		System.out.println("The user has been removed");
	}
}
