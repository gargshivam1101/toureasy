package model.entity;

import java.util.Date;

public class Promotion {
    private String promotionID;
    private String tourID;
    private double discountPercentage;
    private Date startDate;
    private Date endDate;

    public Promotion(String promotionID, String tourID, double discountPercentage, Date startDate, Date endDate) {
        this.promotionID = promotionID;
        this.tourID = tourID;
        this.discountPercentage = discountPercentage;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getPromotionID() {
        return promotionID;
    }

    public String getTourID() {
        return tourID;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }
}