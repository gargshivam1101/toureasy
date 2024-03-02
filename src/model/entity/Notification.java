package model.entity;

import java.util.Date;

public class Notification {
    private String notificationID;
    private String customerID;
    private String message;
    private Date date;
    private String status;

    public Notification(String notificationID, String customerID, String message, Date date, String status) {
        this.notificationID = notificationID;
        this.customerID = customerID;
        this.message = message;
        this.date = date;
        this.status = status;
    }

    public String getNotificationID() {
        return notificationID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getMessage() {
        return message;
    }

    public Date getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }
}