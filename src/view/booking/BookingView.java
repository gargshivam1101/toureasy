package view.booking;

import model.entity.Booking;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class BookingView {

    public void displayMenu() {
        System.out.println("Booking Management System");
        System.out.println("1. Display all bookings");
        System.out.println("2. Display booking details by ID");
        System.out.println("3. Update Booking");
        System.out.println("4. Cancel Booking");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    public void displayAllBookings(List<Booking> bookings) {
        System.out.println("All Bookings:");
        for (Booking booking : bookings) {
            System.out.println(booking);
        }
    }

    public String promptForBookingId() {
        System.out.print("Enter Booking ID: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public String promptForNewTourId() {
        System.out.print("Enter new Tour ID: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void displayBookingDetails(Booking booking) {
        if (booking != null) {
            System.out.println("Booking Details:");
            System.out.println(booking);
        } else {
            System.out.println("Booking not found.");
        }
    }

    public Date promptForNewDate() {
        System.out.print("Enter new date (yyyy-MM-dd): ");
        Scanner scanner = new Scanner(System.in);
        String dateString = scanner.nextLine();

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please enter a date in the format yyyy-MM-dd.");
            return null;
        }
    }

    public String promptForNewStatus() {
        System.out.print("Enter new status: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public String promptForNewPaymentStatus() {
        System.out.print("Enter new payment status: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
