package model.entity;

import java.util.Date;
import java.util.List;

import model.enums.KnownLanguages;

public class Guide extends Person {
	private Double guideCharges;

	public Guide(String firstName, String lastName, Date dob, String contactNo, String email,
			List<KnownLanguages> knownLanguages, Double guideCharges) {
		super(firstName, lastName, dob, contactNo, email, knownLanguages);
		this.guideCharges = guideCharges;
	}

	/**
	 * @return the guideCharges
	 */
	public Double getGuideCharges() {
		return guideCharges;
	}

	/**
	 * @param guideCharges the guideCharges to set
	 */
	public void setGuideCharges(Double guideCharges) {
		this.guideCharges = guideCharges;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Guide [guideCharges=").append(guideCharges).append("]");
		return builder.toString();
	}

}
