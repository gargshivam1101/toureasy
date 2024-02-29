package model.entity;

import java.time.LocalDateTime;
import java.util.List;

import model.enums.KnownLanguages;

public class Customer extends Person {
	private String personalAddress;

	private PaymentInfo paymentInfo;

	public Customer(String firstName, String lastName, LocalDateTime dob, String contactNo, String email,
			List<KnownLanguages> knownLanguages, String personalAddress, PaymentInfo paymentInfo) {
		super(firstName, lastName, dob, contactNo, email, knownLanguages);
		this.personalAddress = personalAddress;
		this.paymentInfo = paymentInfo;
	}

	/**
	 * @return the personalAddress
	 */
	public String getPersonalAddress() {
		return personalAddress;
	}

	/**
	 * @param personalAddress the personalAddress to set
	 */
	public void setPersonalAddress(String personalAddress) {
		this.personalAddress = personalAddress;
	}

	/**
	 * @return the paymentInfo
	 */
	public PaymentInfo getPaymentInfo() {
		return paymentInfo;
	}

	/**
	 * @param paymentInfo the paymentInfo to set
	 */
	public void setPaymentInfo(PaymentInfo paymentInfo) {
		this.paymentInfo = paymentInfo;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Customer [personalAddress=").append(personalAddress).append(", paymentInfo=")
				.append(paymentInfo).append("]");
		return builder.toString();
	}
}
