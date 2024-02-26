package model.entity;

public class Wallet {

	private String walletId;
	private double walletBalance;

	public Wallet(String walletId, double walletBalance) {
		super();
		this.walletId = walletId;
		this.walletBalance = walletBalance;
	}

	/**
	 * @return the walletId
	 */
	public String getWalletId() {
		return walletId;
	}

	/**
	 * @param walletId the walletId to set
	 */
	public void setWalletId(String walletId) {
		this.walletId = walletId;
	}

	/**
	 * @return the walletBalance
	 */
	public double getWalletBalance() {
		return walletBalance;
	}

	/**
	 * @param walletBalance the walletBalance to set
	 */
	public void setWalletBalance(double walletBalance) {
		this.walletBalance = walletBalance;
	}

	public void topUp(double amount) {
		walletBalance += amount;
		System.out.println("Wallet topped up successfully. Current balance: " + walletBalance);
	}

	public void withdraw(double amount) {
		if (walletBalance >= amount) {
			walletBalance -= amount;
			System.out.println("Withdrawal successful. Remaining balance: " + walletBalance);
		} else {
			System.out.println("Insufficient funds. Withdrawal failed.");
		}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Wallet [walletId=").append(walletId).append(", walletBalance=").append(walletBalance)
				.append("]");
		return builder.toString();
	}

}
