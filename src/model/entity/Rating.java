package model.entity;

public class Rating {
    private String ratingID;
    private String tourID;
    private String guideID;
    private String customerID;
    private int stars;

    // Constructors
    public Rating() {
        // Default constructor
    }

    public Rating(String ratingID, String tourID, String guideID, String customerID, int stars) {
        this.ratingID = ratingID;
        this.tourID = tourID;
        this.guideID = guideID;
        this.customerID = customerID;
        this.stars = stars;
    }

    // Getters and Setters
    public String getRatingID() {
        return ratingID;
    }

    public void setRatingID(String ratingID) {
        this.ratingID = ratingID;
    }

    public String getTourID() {
        return tourID;
    }

    public void setTourID(String tourID) {
        this.tourID = tourID;
    }

    public String getGuideID() {
        return guideID;
    }

    public void setGuideID(String guideID) {
        this.guideID = guideID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    // toString method
    @Override
    public String toString() {
        return "Rating [ratingID=" + ratingID + ", tourID=" + tourID + ", guideID=" + guideID + ", customerID="
                + customerID + ", stars=" + stars + "]";
    }
}
