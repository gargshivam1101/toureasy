package model.entity;

import java.util.concurrent.atomic.AtomicInteger;

public class Hotel {

	private static final AtomicInteger count = new AtomicInteger(0);

	private Integer hotelId;
	private String hotelName;
	private String hotelAddress;
	private Person manager;
	private String cityName;
	private int numberOfAvailableRooms;
	private float price;

	public Hotel(String hotelName, String hotelAddress, Person manager, String cityName, int numberOfAvailableRooms,
			float price) {
		super();
		this.hotelId = count.incrementAndGet();
		this.hotelName = hotelName;
		this.hotelAddress = hotelAddress;
		this.manager = manager;
		this.cityName = cityName;
		this.numberOfAvailableRooms = numberOfAvailableRooms;
		this.price = price;
	}

	/**
	 * @return the hotelId
	 */
	public Integer getHotelId() {
		return hotelId;
	}

	/**
	 * @param hotelId the hotelId to set
	 */
	public void setHotelId(Integer hotelId) {
		this.hotelId = hotelId;
	}

	/**
	 * @return the hotelName
	 */
	public String getHotelName() {
		return hotelName;
	}

	/**
	 * @param hotelName the hotelName to set
	 */
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	/**
	 * @return the hotelAddress
	 */
	public String getHotelAddress() {
		return hotelAddress;
	}

	/**
	 * @param hotelAddress the hotelAddress to set
	 */
	public void setHotelAddress(String hotelAddress) {
		this.hotelAddress = hotelAddress;
	}

	/**
	 * @return the manager
	 */
	public Person getManager() {
		return manager;
	}

	/**
	 * @param manager the manager to set
	 */
	public void setManager(Person manager) {
		this.manager = manager;
	}

	/**
	 * @return the cityName
	 */
	public String getCityName() {
		return cityName;
	}

	/**
	 * @param cityName the cityName to set
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	/**
	 * @return the numberOfAvailableRooms
	 */
	public int getNumberOfAvailableRooms() {
		return numberOfAvailableRooms;
	}

	/**
	 * @param numberOfAvailableRooms the numberOfAvailableRooms to set
	 */
	public void setNumberOfAvailableRooms(int numberOfAvailableRooms) {
		this.numberOfAvailableRooms = numberOfAvailableRooms;
	}

	/**
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Hotel [hotelId=").append(hotelId).append(", hotelName=").append(hotelName)
				.append(", hotelAddress=").append(hotelAddress).append(", manager=").append(manager)
				.append(", cityName=").append(cityName).append(", numberOfAvailableRooms=")
				.append(numberOfAvailableRooms).append(", price=").append(price).append("]");
		return builder.toString();
	}
}
