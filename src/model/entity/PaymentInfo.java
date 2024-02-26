package model.entity;

import model.enums.PaymentMode;

public class PaymentInfo {
	private String billingName;
	private String billingAddress;
	private PaymentMode preferredModeOfPayment;
	private Wallet walletDetails;
	private String cardDetails;

	public PaymentInfo(String billingName, String billingAddress, PaymentMode preferredModeOfPayment,
			Wallet walletDetails, String cardDetails) {
		super();
		this.billingName = billingName;
		this.billingAddress = billingAddress;
		this.preferredModeOfPayment = preferredModeOfPayment;
		this.walletDetails = walletDetails;
		this.cardDetails = cardDetails;
	}

	/**
	 * @return the billingName
	 */
	public String getBillingName() {
		return billingName;
	}

	/**
	 * @param billingName the billingName to set
	 */
	public void setBillingName(String billingName) {
		this.billingName = billingName;
	}

	/**
	 * @return the billingAddress
	 */
	public String getBillingAddress() {
		return billingAddress;
	}

	/**
	 * @param billingAddress the billingAddress to set
	 */
	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}

	/**
	 * @return the preferredModeOfPayment
	 */
	public PaymentMode getPreferredModeOfPayment() {
		return preferredModeOfPayment;
	}

	/**
	 * @param preferredModeOfPayment the preferredModeOfPayment to set
	 */
	public void setPreferredModeOfPayment(PaymentMode preferredModeOfPayment) {
		this.preferredModeOfPayment = preferredModeOfPayment;
	}

	/**
	 * @return the walletDetails
	 */
	public Wallet getWalletDetails() {
		return walletDetails;
	}

	/**
	 * @param walletDetails the walletDetails to set
	 */
	public void setWalletDetails(Wallet walletDetails) {
		this.walletDetails = walletDetails;
	}

	/**
	 * @return the cardDetails
	 */
	public String getCardDetails() {
		return cardDetails;
	}

	/**
	 * @param cardDetails the cardDetails to set
	 */
	public void setCardDetails(String cardDetails) {
		this.cardDetails = cardDetails;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PaymentInfo [billingName=").append(billingName).append(", billingAddress=")
				.append(billingAddress).append(", preferredModeOfPayment=").append(preferredModeOfPayment)
				.append(", walletDetails=").append(walletDetails).append(", cardDetails=").append(cardDetails)
				.append("]");
		return builder.toString();
	}

}
