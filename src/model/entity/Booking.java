package model.entity;

import java.util.Date;

public class Booking {
	private String bookingID;
	private String tourID;
	private String customerID;
	private Date date;
	private String status;
	private PaymentInfo paymentInfo;
	private String paymentStatus;
	private SpecialRequest specialRequest;

	public Booking() {
		// Default constructor
	}

	public Booking(String bookingID, String tourID, String customerID, Date date, String status, String paymentStatus, PaymentInfo paymentInfo) {
		super();
		this.bookingID = bookingID;
		this.tourID = tourID;
		this.customerID = customerID;
		this.date = date;
		this.status = status;
		this.paymentStatus = paymentStatus;
		this.specialRequest = specialRequest;
		this.paymentInfo = paymentInfo;
	}

	public String getBookingID() {
		return bookingID;
	}

	public void setBookingID(String bookingID) {
		this.bookingID = bookingID;
	}

	public String getTourID() {
		return tourID;
	}

	public void setTourID(String tourID) {
		this.tourID = tourID;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	/**
	 * @return the specialRequest
	 */
	public SpecialRequest getSpecialRequest() {
		return specialRequest;
	}

	/**
	 * @param specialRequest the specialRequest to set
	 */
	public void setSpecialRequest(SpecialRequest specialRequest) {
		this.specialRequest = specialRequest;
	}

	public PaymentInfo getPaymentInfo() {
		return paymentInfo;
	}

	public void setPaymentInfo(PaymentInfo paymentInfo) {
		this.paymentInfo = paymentInfo;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Booking [bookingID=").append(bookingID).append(", tourID=").append(tourID)
				.append(", customerID=").append(customerID).append(", date=").append(date).append(", status=")
				.append(status).append(", paymentStatus=").append(paymentStatus).append(", specialRequest=")
				.append(specialRequest).append("]");
		return builder.toString();
	}
}
