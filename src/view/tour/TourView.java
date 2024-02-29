package view.tour;

import java.util.List;
import java.util.Scanner;

import model.entity.Review;
import model.entity.Tour;

public class TourView {
    public static void displayMenu() {
        System.out.println("\n***** Tour Management System *****");
        System.out.println("1. View All Tours");
        System.out.println("2. View Tour Details");
        System.out.println("3. View Tour Reviews");
        System.out.println("4. Book a Tour");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    public static void displayAllTours(List<Tour> tours) {
        System.out.println("\n*** All Tours ***");
        for (Tour tour : tours) {
            System.out.println(tour.toString());
        }
    }

    public static void displayTourDetails(Tour tour) {
        System.out.println("\n*** Tour Details ***");
        System.out.println(tour.toString());
    }

    public static void displayTourReviews(List<Review> reviews) {
        System.out.println("\n*** Tour Reviews ***");
        for (Review review : reviews) {
            System.out.println(review.toString());
        }
    }
    public static String promptForTourId() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the Tour ID: ");
        return scanner.nextLine();
    }
}
