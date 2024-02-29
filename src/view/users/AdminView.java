package view.users;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import model.entity.User;
import model.enums.Role;

public class AdminView {

	public static Integer showMenuAndChoose(User loggedInUser) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("1. Show All Users");
		System.out.println("2. Add User");
		System.out.println("3. Remove User");
		System.out.println("4. Get all bookings");
		System.out.println("5. View all hotels");
		System.out.println("6. Add a hotel");
		System.out.println("7. View Tours");
		System.out.println("8. Add Tours");
		System.out.println("9. Edit Tours");
		System.out.println("10. Remove Tour");
		System.out.println("11. Manage and Promote Events");
		System.out.println("12. View Cancellation Policy");
		System.out.println("13. Update Cancellation Policy");
		System.out.println("0. Logout");
		System.out.print("Enter your choice: ");

		int choice = scanner.nextInt();

		return choice;
	}

	public static void promptToAddUser() {
		System.out.println("Please add the details of the new user below");
	}

	public static String getFirstNameInput() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("First Name: ");
		return scanner.nextLine();
	}

	public static String getLastNameInput() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Last Name: ");
		return scanner.nextLine();
	}

	public static String getEmailInput() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Email: ");
		return scanner.nextLine();
	}

	public static LocalDateTime getDateOfBirthInput() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Date Of Birth (DD-MM-YYYY): ");
		String dobInput = scanner.nextLine();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate val = LocalDate.parse(dobInput, formatter);
		return val.atStartOfDay();
	}

	public static Role getRoleInput() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Role: ");
		String roleInp = scanner.nextLine();
		return Role.fromString(roleInp);
	}

	public static void promptToRemoveUser() {
		System.out.println("Please enter the email of user to be removed");
	}
}
