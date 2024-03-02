package model.entity;

import model.enums.ModeOfTransport;

public class Tour {
	private String tourId;
	private Destination destination;
	private Integer numberOfNights;
	private Hotel hotel;
	private ModeOfTransport inCityModeOfTransport;
	private Guide guide;

	public Tour(String tourId, Destination destination, Integer numberOfNights, Hotel hotel,
			ModeOfTransport inCityModeOfTransport, Guide guide) {
		super();
		this.tourId = tourId;
		this.destination = destination;
		this.numberOfNights = numberOfNights;
		this.hotel = hotel;
		this.inCityModeOfTransport = inCityModeOfTransport;
		this.guide = guide;
	}

	/**
	 * @return the tourId
	 */
	public String getTourId() {
		return tourId;
	}

	/**
	 * @param tourId the tourId to set
	 */
	public void setTourId(String tourId) {
		this.tourId = tourId;
	}

	/**
	 * @return the destination
	 */
	public Destination getDestination() {
		return destination;
	}

	/**
	 * @param destination the destination to set
	 */
	public void setDestination(Destination destination) {
		this.destination = destination;
	}

	/**
	 * @return the numberOfNights
	 */
	public Integer getNumberOfNights() {
		return numberOfNights;
	}

	/**
	 * @param numberOfNights the numberOfNights to set
	 */
	public void setNumberOfNights(Integer numberOfNights) {
		this.numberOfNights = numberOfNights;
	}

	/**
	 * @return the hotel
	 */
	public Hotel getHotel() {
		return hotel;
	}

	/**
	 * @param hotel the hotel to set
	 */
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	/**
	 * @return the inCityModeOfTransport
	 */
	public ModeOfTransport getInCityModeOfTransport() {
		return inCityModeOfTransport;
	}

	/**
	 * @param inCityModeOfTransport the inCityModeOfTransport to set
	 */
	public void setInCityModeOfTransport(ModeOfTransport inCityModeOfTransport) {
		this.inCityModeOfTransport = inCityModeOfTransport;
	}

	/**
	 * @return the guide
	 */
	public Guide getGuide() {
		return guide;
	}

	/**
	 * @param guide the guide to set
	 */
	public void setGuide(Guide guide) {
		this.guide = guide;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Tour [tourId=").append(tourId).append(", destination=").append(destination)
				.append(", numberOfNights=").append(numberOfNights).append(", hotel=").append(hotel)
				.append(", inCityModeOfTransport=").append(inCityModeOfTransport).append(", guide=").append(guide)
				.append("]");
		return builder.toString();
	}

}
