package model.enums;

public enum Role {
	CUSTOMER, //
	GUIDE, //
	ADMINISTRATOR;

	public static Role fromString(String text) {
		for (Role role : Role.values()) {
			if (role.name().equalsIgnoreCase(text)) {
				return role;
			}
		}
		throw new IllegalArgumentException("No constant with name " + text + " found in enum");
	}
}
