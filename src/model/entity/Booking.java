package model.entity;

import java.util.Date;
public class Booking {
    private String bookingID;
    private String tourID;
    private String customerID;
    private Date date;
    private String status;
    private String paymentStatus;

    public Booking() {
        // Default constructor
    }

    public Booking(String bookingID, String tourID, String customerID, Date date, String status, String paymentStatus) {
        this.bookingID = bookingID;
        this.tourID = tourID;
        this.customerID = customerID;
        this.date = date;
        this.status = status;
        this.paymentStatus = paymentStatus;
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

    // toString method
    @Override
    public String toString() {
        return "Booking [bookingID=" + bookingID + ", tourID=" + tourID + ", customerID=" + customerID + ", date=" + date
                + ", status=" + status + ", paymentStatus=" + paymentStatus + "]";
    }
}
