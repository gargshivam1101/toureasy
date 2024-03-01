package view.users;

import model.entity.Booking;
import model.entity.User;

import java.util.List;
import java.util.Scanner;

public class CustomerView extends UserView {
	public static Integer showMenuAndChoose(User loggedInUser) {
      Scanner scanner = new Scanner(System.in);
      
      System.out.println("1. Show Profile");
      System.out.println("2. Edit Profile");
      System.out.println("3. Make a booking");
      System.out.println("4. Edit a booking");
      System.out.println("111. Access FAQ");
      System.out.println("0. Logout");
      System.out.print("Enter your choice: ");
      return getUserChoice();
    }

    public static String promptForBookingId() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter Booking ID: ");
            return scanner.nextLine();
    }

    public static String promptForTourId() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter Tour ID: ");
            return scanner.nextLine();
    }

    public static String promptForBookingStatus() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter Booking Status: ");
            return scanner.nextLine();
    }

    public static String promptForBookingPaymentStatus() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter Booking Payment Status: ");
            return scanner.nextLine();
    }

    public static void displayAllMyBookings(List<Booking> bookings) {
            System.out.println("My Bookings:");
            for (Booking booking : bookings) {
                  System.out.println(booking);
            }
    }
    private static int getUserChoice() {
            Scanner scanner = new Scanner(System.in);
            int choice = -1;

            while (true) {
                  System.out.print("Enter your choice: ");
                  try {
                        choice = scanner.nextInt();
                        break;  // Exit the loop if the input is a valid integer
                  } catch (Exception e) {
                        System.out.println("Invalid input. Please enter a valid integer.");
                        scanner.nextLine();  // Clear the buffer
                  }
            }
            return choice;
    }
}
