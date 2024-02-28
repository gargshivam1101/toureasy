package controller.tour;

import model.bl.tour.TourService;
import model.entity.Review;
import model.entity.Tour;
import view.tour.TourView;

import java.util.List;
import java.util.Scanner;

public class TourController {

    private TourService tourService;
    private TourView tourView;

    public TourController(TourService tourService, TourView tourView) {
        this.tourService = tourService;
        this.tourView = tourView;
    }

    public void processUserInput() {
        int choice;
        do {
            tourView.displayMenu();
            choice = getUserChoice();

            switch (choice) {
                case 1:
                    List<Tour> allTours = tourService.getAllTours();
                    tourView.displayAllTours(allTours);
                    break;
                case 2:
                    String tourIdDetails = tourView.promptForTourId();
                    Tour tourDetails = tourService.getTourById(tourIdDetails);
                    tourView.displayTourDetails(tourDetails);
                    break;
                case 3:
                    String tourIdReviews = tourView.promptForTourId();
                    List<Review> tourReviews = tourService.getReviewsByTourId(tourIdReviews);
                    tourView.displayTourReviews(tourReviews);
                    break;
                case 4:
                    // =======================
                    // BOOKING LOGIC GOES HERE
                    // =======================
                    break;
                case 5:
                    System.out.println("Exiting Tour Management System.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }

    private int getUserChoice() {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        while (choice < 1 || choice > 5) {
            System.out.print("Enter your choice (1-5): ");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();

                if (choice < 1 || choice > 5) {
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();
            }
        }

        return choice;
    }
}
