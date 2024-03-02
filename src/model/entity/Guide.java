package model.entity;

import java.time.LocalDateTime;
import java.util.List;

import model.enums.KnownLanguages;
import model.enums.Role;

public class Guide extends User {
	private Double guideCharges;

	public Guide(User user, Double guideCharges) {
		super(user.getFirstName(), user.getLastName(), user.getDob(), user.getContactNo(), user.getEmail(),
				user.getKnownLanguages(), user.getPassword(), user.getRole());
		this.guideCharges = guideCharges;
	}

	public Guide(String firstName, String lastName, LocalDateTime dob, String contactNo, String email,
			List<KnownLanguages> knownLanguages, String password, Role role, Double guideCharges) {
		super(firstName, lastName, dob, contactNo, email, knownLanguages, password, role);
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
