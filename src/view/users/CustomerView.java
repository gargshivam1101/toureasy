package view.users;

import model.entity.Booking;
import model.entity.User;

import java.util.List;
import java.util.Scanner;

public class CustomerView extends UserView {

      public static int showMenuAndChoose(User loggedInUser) {
            System.out.println("Customer Menu:");
            System.out.println("1. View my profile");
            System.out.println("2. Edit my profile");
            System.out.println("3. View my bookings");
            System.out.println("4. Cancel my booking");
            System.out.println("5. Create a new booking");
            System.out.println("0. Logout");

            // Get user choice
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
