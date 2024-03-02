package model.bl.user;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import model.bl.hotel.HotelService;
import model.bl.tour.TourService;
import model.entity.Admin;
import model.entity.Destination;
import model.entity.Guide;
import model.entity.Hotel;
import model.entity.Person;
import model.entity.Tour;
import model.entity.User;
import model.enums.KnownLanguages;
import model.enums.ModeOfTransport;
import model.enums.Role;

public class AdminService extends UserService {

	static List<Admin> adminList = new ArrayList<>();

	public static List<Admin> getAdminList() {
		return getUserList().stream().filter(u -> u.getRole().equals(Role.ADMINISTRATOR))
				.map(u -> new Admin(u, "Overall", null, 300.0)).collect(Collectors.toList());
	}

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

//	public static void addTour(String tourId, String destination, Integer numberOfNights, Hotel hotel,
//							   ModeOfTransport inCityModeOfTransport, Guide guide) {
//		Tour newTour = new Tour(tourId, destination, numberOfNights, hotel, inCityModeOfTransport, guide);
//		TourService.addTour(newTour);
//		System.out.println("The tour has been added");
//	}

	public static void showAllTours() {
		TourService.getAllTours().forEach(t -> {
			System.out.println("Tour Id: " + t.getTourId());
			System.out.println("Destination: " + t.getDestination().getName());
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

	public static void addHotel(String hotelName, String hotelAddress, String cityName, Integer noOfAvailRooms,
			Float price, String mfirstName, String mlastName, LocalDateTime mdob, String mcontactNo, String memail,
			List<KnownLanguages> mknownLanguages) {
		Person manager = new Person(mfirstName, mlastName, mdob, mcontactNo, memail, mknownLanguages);
		Hotel hotel = new Hotel(hotelName, hotelAddress, manager, cityName, noOfAvailRooms, price);
		HotelService.putHotelList(hotel);
		System.out.println("The hotel has been added");
	}

	public static void addTour(String tourId, String destinationName, String destinationDesc,
			List<String> destAttractions, Integer numberOfNights, Integer hotelId, ModeOfTransport modeofTransport,
			String guideEmail) {
		Hotel hotel = HotelService.getHotelById(hotelId);
		Destination destination = new Destination(destinationName, destinationDesc, destAttractions);
		Guide guide = GuideService.getGuideByEmail(guideEmail);
		Tour tour = new Tour(tourId, destination, numberOfNights, hotel, modeofTransport, guide);
		TourService.putTourList(tour);
		System.out.println("The tour has been added");
	}
}
