package model.entity;

import java.util.Date;
import java.util.List;

import model.enums.KnownLanguages;

public class Person {

	private String firstName;
	private String lastName;
	private Date dob;
	private String contactNo;
	private String email;
	private List<KnownLanguages> knownLanguages;

	public Person(String firstName, String lastName, Date dob, String contactNo, String email,
			List<KnownLanguages> knownLanguages) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.contactNo = contactNo;
		this.email = email;
		this.knownLanguages = knownLanguages;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the dob
	 */
	public Date getDob() {
		return dob;
	}

	/**
	 * @param dob the dob to set
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}

	/**
	 * @return the contactNo
	 */
	public String getContactNo() {
		return contactNo;
	}

	/**
	 * @param contactNo the contactNo to set
	 */
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the knownLanguages
	 */
	public List<KnownLanguages> getKnownLanguages() {
		return knownLanguages;
	}

	/**
	 * @param knownLanguages the knownLanguages to set
	 */
	public void setKnownLanguages(List<KnownLanguages> knownLanguages) {
		this.knownLanguages = knownLanguages;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Person [firstName=").append(firstName).append(", lastName=").append(lastName).append(", dob=")
				.append(dob).append(", contactNo=").append(contactNo).append(", email=").append(email)
				.append(", knownLanguages=").append(knownLanguages).append("]");
		return builder.toString();
	}
}
