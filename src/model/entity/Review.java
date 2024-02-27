package model.entity;

import java.util.Date;

public class Review extends Rating {
    private String reviewID;
    private String comment;
    private Date date;

    // Constructors
    public Review() {
        // Default constructor
    }

    public Review(String reviewID, String tourID, String customerID, int stars, String comment, Date date) {
        super(); // Call the default constructor of the superclass (Rating)
        this.reviewID = reviewID;
        setTourID(tourID); // Accessors of the superclass
        setCustomerID(customerID); // Accessors of the superclass
        setStars(stars); // Accessors of the superclass
        this.comment = comment;
        this.date = date;
    }

    // Getters and Setters
    public String getReviewID() {
        return reviewID;
    }

    public void setReviewID(String reviewID) {
        this.reviewID = reviewID;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    // toString method
    @Override
    public String toString() {
        return "Review [reviewID=" + reviewID + ", tourID=" + getTourID() + ", customerID=" + getCustomerID()
                + ", stars=" + getStars() + ", comment=" + comment + ", date=" + date + "]";
    }
}