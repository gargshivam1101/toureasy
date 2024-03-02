package model.entity;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Destination {

	private static final AtomicInteger count = new AtomicInteger(0);

	private Integer destinationId;
	private String name;
	private String description;
	private List<String> attractions;

	public Destination(String name, String description, List<String> attractions) {
		super();
		this.destinationId = count.incrementAndGet();
		this.name = name;
		this.description = description;
		this.attractions = attractions;
	}

	/**
	 * @return the destinationId
	 */
	public Integer getDestinationId() {
		return destinationId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the attractions
	 */
	public List<String> getAttractions() {
		return attractions;
	}

	/**
	 * @param attractions the attractions to set
	 */
	public void setAttractions(List<String> attractions) {
		this.attractions = attractions;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Destination [destinationId=").append(destinationId).append(", name=").append(name)
				.append(", description=").append(description).append(", attractions=").append(attractions).append("]");
		return builder.toString();
	}
}
