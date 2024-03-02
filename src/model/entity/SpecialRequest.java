package model.entity;

public class SpecialRequest {

	private Boolean isApproved;

	private String description;

	public SpecialRequest(Boolean isApproved, String description) {
		super();
		this.isApproved = isApproved;
		this.description = description;
	}

	/**
	 * @return the isApproved
	 */
	public Boolean getIsApproved() {
		return isApproved;
	}

	/**
	 * @param isApproved the isApproved to set
	 */
	public void setIsApproved(Boolean isApproved) {
		this.isApproved = isApproved;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SpecialRequest [isApproved=").append(isApproved).append(", description=").append(description)
				.append("]");
		return builder.toString();
	}
}
