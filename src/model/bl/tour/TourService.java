package model.bl.tour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import model.entity.Destination;
import model.entity.Guide;
import model.entity.Hotel;
import model.entity.Person;
import model.entity.Review;
import model.entity.Tour;
import model.enums.KnownLanguages;
import model.enums.ModeOfTransport;
import model.enums.Role;

public class TourService {
	static List<Tour> tourList = new ArrayList<>(Arrays.asList(//
			new Tour("T001", new Destination("City Tour", "A tour of the city", null), 2,
					new Hotel("City Hotel", "123 Main St",
							new Person("John", "Doe", null, "123-456-7890", "john.doe@email.com", null), "City", 50,
							100.0F),
					ModeOfTransport.BUS,
					new Guide("GuideFirstName", "GuideLastName", null, "987-654-3210", "guide@email.com",
							Arrays.asList(KnownLanguages.ENGLISH, KnownLanguages.SPANISH), "pass", Role.GUIDE, 50.0)),

			new Tour("T002", new Destination("Mountain Hoke", "A hike through the beautiful mountains", null), 3,
					new Hotel("Mountain Lodge", "456 Mountain Rd",
							new Person("Jane", "Smith", null, "987-654-3210", "jane.smith@email.com", null),
							"Mountains", 30, 120.0F),
					ModeOfTransport.BUS,
					new Guide("AnotherGuide", "GuideLastName", null, "123-789-4560", "another.guide@email.com",
							Arrays.asList(KnownLanguages.FRENCH, KnownLanguages.GERMAN), "pass", Role.GUIDE, 60.0))));

	
	static List<Review> reviewList = new ArrayList<>(
			Arrays.asList(new Review("R001", "T001", null, 4, "Great city tour!", null),
					new Review("R002", "T002", null, 5, "Amazing mountain hike!", null)));

	public static List<Review> getReviewsByTourId(String tourId) {
		return reviewList.stream().filter(review -> review.getTourID().equals(tourId)).collect(Collectors.toList());
	}

	public static List<Tour> getAllTours() {
		return tourList;
	}

	public static void addTour(Tour tour) {
		tourList.add(tour);
	}

	public static Tour getTourById(String tourId) {
		return tourList.stream().filter(tour -> tour.getTourId().equals(tourId)).findFirst().orElse(null);
	}

	public static void putTourList(Tour tour) {
		tourList.add(tour);
	}
}
