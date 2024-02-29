package model.entity;

import java.time.LocalDateTime;
import java.util.List;

import model.enums.KnownLanguages;
import model.enums.Role;

public class User extends Person {

	private String password;

	private Role role;

	public User(String firstName, String lastName, LocalDateTime dob, String contactNo, String email,
			List<KnownLanguages> knownLanguages, String password, Role role) {
		super(firstName, lastName, dob, contactNo, email, knownLanguages);
		this.password = password;
		this.role = role;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [password=").append(password).append(", role=").append(role).append("]");
		return builder.toString();
	}
}
