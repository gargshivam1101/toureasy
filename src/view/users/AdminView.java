package view.users;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import model.entity.User;
import model.enums.ModeOfTransport;
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

	public static void promptToAddHotel() {
		System.out.println("Please enter the details of the hotel, and it's manager below");
	}
	
	public static String getHotelNameInput() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Hotel Name: ");
		return scanner.nextLine();
	}

	public static String getHotelAddressInput() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Hotel Address: ");
		return scanner.nextLine();
	}

	public static String getCityNameInput() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("City Name: ");
		return scanner.nextLine();
	}

	public static Integer getNoOfRoomsInp() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Number of Rooms: ");
		return scanner.nextInt();
	}

	public static Float getPriceInp() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Price: ");
		return scanner.nextFloat();
	}

	public static void promptToAddTour() {
		System.out.println("Please add the details of the tour below");
	}

	public static String getTourIdInput() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Tour ID: ");
		return scanner.nextLine();
	}

	public static String getDestinationNameInput() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Destination Name: ");
		return scanner.nextLine();
	}
	
	public static String getDestinationDescInput() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Destination Description: ");
		return scanner.nextLine();
	}

	public static List<String> getDestinationAttractionsInput() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Destination Attractions (space separated): ");
		String attractionsInp = scanner.nextLine();
		String[] attractionsArr = attractionsInp.split(" ");
		return new ArrayList<>(Arrays.asList(attractionsArr));
	}
	
	public static Integer getNoOfNightsInput() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Number of Nights: ");
		return scanner.nextInt();
	}

	public static Integer getHotelIdInput() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Hotel ID: ");
		return scanner.nextInt();
	}

	public static ModeOfTransport getModeOfTransportInput() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Mode of Transport: ");
		String inp = scanner.nextLine();
		return ModeOfTransport.fromString(inp);
	}

	public static String getGuideEmailInput() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Email of Guide: ");
		return scanner.nextLine();
	}
}
