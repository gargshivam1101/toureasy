package model.bl.user;

import java.time.LocalDateTime;
import java.util.List;

import model.bl.hotel.HotelService;
import model.bl.tour.TourService;
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

	public static void showAllTours() {
		TourService.getAllTours().forEach(t -> {
			System.out.println("Tour Id: " + t.getTourId());
			System.out.println("Destination: " + t.getDestination());
			System.out.println("Hotel: " + t.getHotel().getHotelName());
			System.out.println("Number of Nights: " + t.getNumberOfNights());
			System.out.println();
		});
	}

	public static void showAllHotels() {
		HotelService.getHotelList().forEach(h -> {
			System.out.println("Hotel Id: " + h.getHotelId());
			System.out.println("Hotel Name: " + h.getHotelName());
			System.out.println("Hotel City: " + h.getCityName());
			System.out.println("Price: " + h.getPrice());
			System.out.println("Manager Name: " + h.getManager().getFirstName() + " " + h.getManager().getLastName());
			System.out.println();
		});
	}
}
