package model.bl.booking;

import java.util.*;
import java.util.stream.Collectors;

import model.bl.tour.TourService;
import model.entity.*;
import model.enums.PaymentMode;

public class BookingService {

	// Assume this list is populated with some initial bookings
	static List<Booking> bookingList = new ArrayList<>(
			Arrays.asList(new Booking("B001", "T001", "C001", new Date(), "Confirmed", "Paid", null),
					new Booking("B002", "T002", "C002", new Date(), "Confirmed", "Pending", null)));

	public static List<Booking> getAllBookings() {
		return bookingList;
	}

	public static Booking getBookingById(String bookingId) {
		return bookingList.stream().filter(booking -> booking.getBookingID().equals(bookingId)).findFirst()
				.orElse(null);
	}

	public static List<Booking> getBookingsByCustomer(String customerId) {
		return bookingList.stream().filter(booking -> booking.getCustomerID().equals(customerId))
				.collect(Collectors.toList());
	}

	public static List<Booking> getBookingsByTour(String tourId) {
		return bookingList.stream().filter(booking -> booking.getTourID().equals(tourId)).collect(Collectors.toList());
	}

    public static Booking createBooking(String tourId, String customerID, Date date, PaymentInfo paymentInfo) {
        // Check if the tour exists
		Tour tour = TourService.getTourById(tourId);
		if (tour != null) {
			// Generate a unique booking ID
			String bookingId = UUID.randomUUID().toString();

			// Get current date and time
			Date currentDate = new Date();

			// Make SpecialRequest
			SpecialRequest spRequestObj = new SpecialRequest(false, "specialRequest");

            processPayment(paymentInfo);

			// Create a new booking
			Booking booking = new Booking(bookingId, tourId, customerID, currentDate, "Pending", "Pending",
					paymentInfo);

			// Add the booking to the list
			bookingList.add(booking);

			System.out.println("Booking created successfully.");
			return booking;
		} else {
			System.out.println("Tour not found. Cannot create booking.");
			return null;
		}
	}

	public static void updateBooking(String bookingId, String tourId, Date date, String status, String paymentStatus) {
		Booking booking = getBookingById(bookingId);
		if (booking != null) {
			booking.setTourID(tourId);
			booking.setDate(date);
			booking.setStatus(status);
			booking.setPaymentStatus(paymentStatus);
			System.out.println("Booking details updated successfully.");
		} else {
			System.out.println("Booking not found.");
		}
	}

	public static void cancelBooking(String bookingId) {
		Booking booking = getBookingById(bookingId);
		if (booking != null) {
			booking.setStatus("Cancelled");
			System.out.println("Booking cancelled successfully.");
		} else {
			System.out.println("Booking not found.");
		}
	}

    private static void processPayment(PaymentInfo paymentInfo) {
        if (paymentInfo != null) {
            PaymentMode paymentMode = paymentInfo.getPreferredModeOfPayment();
            if (paymentMode == PaymentMode.CARD) {

                String cardDetails = paymentInfo.getCardDetails();

                System.out.println("Payment successful using card. Card details: " + cardDetails);
            } else if (paymentMode == PaymentMode.WALLET) {
                // perform wallet payment logic
                Wallet walletDetails = paymentInfo.getWalletDetails();
                double bookingAmount = calculateBookingAmount();
                if (walletDetails != null && walletDetails.getWalletBalance() >= bookingAmount) {
                    walletDetails.withdraw(bookingAmount);
                    System.out.println("Payment successful using wallet. Remaining wallet balance: " + walletDetails.getWalletBalance());
                } else {
                    System.out.println("Payment failed. Insufficient funds in the wallet.");
                }
            }
        }
    }

    private static double calculateBookingAmount() {
        double minPrice = 10.0;
        double maxPrice = 100.0;

        // Create a Random object
        Random random = new Random();

        // Generate a random price within the specified range
        double randomPrice = minPrice + (maxPrice - minPrice) * random.nextDouble();
        return randomPrice;
    }

}
