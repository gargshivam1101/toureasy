package controller.booking;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import model.bl.booking.BookingService;
import model.entity.Booking;
import view.booking.BookingView;

public class BookingController {

    private BookingService bookingService;
    private BookingView bookingView;

    public BookingController(BookingService bookingService, BookingView bookingView) {
        this.bookingService = bookingService;
        this.bookingView = bookingView;
    }

    public void processUserInput() {
        int choice;
        do {
            bookingView.displayMenu();
            choice = getUserChoice();

            switch (choice) {
                case 1:
                    // Display all bookings
                    List<Booking> allBookings = bookingService.getAllBookings();
                    bookingView.displayAllBookings(allBookings);
                    break;
                case 2:
                    // Display booking details by ID
                    String bookingId = bookingView.promptForBookingId();
                    Booking bookingDetails = bookingService.getBookingById(bookingId);
                    bookingView.displayBookingDetails(bookingDetails);
                    break;
                case 3:
                    // Update a booking
                    String updateBookingId = bookingView.promptForBookingId();
                    String newTourId = bookingView.promptForNewTourId();
                    String newDate = promptForNewDate();
                    String newStatus = bookingView.promptForNewStatus();
                    String newPaymentStatus = bookingView.promptForNewPaymentStatus();

                    try {
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Adjust the format as needed
                        Date parsedDate = dateFormat.parse(newDate);
                        bookingService.updateBooking(updateBookingId, newTourId, parsedDate, newStatus, newPaymentStatus);
                    } catch (ParseException e) {
                        System.out.println("Error parsing date. Please enter a valid date format.");
                    }
                    break;
                case 4:
                    // Cancel a booking
                    String cancelBookingId = bookingView.promptForBookingId();
                    bookingService.cancelBooking(cancelBookingId);
                    break;
                case 5:
                    System.out.println("Exiting Booking Management System.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }

    private int getUserChoice() {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        while (true) {
            System.out.print("Enter your choice: ");
            try {
                choice = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine();
            }
        }
        return choice;
    }
    private String promptForNewDate() {
        System.out.print("Enter new date (yyyy-MM-dd): ");
        Scanner scanner = new Scanner(System.in);
        String dateString = scanner.nextLine();
        return dateString;
    }
}
