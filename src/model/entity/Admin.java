package model.entity;

import java.time.LocalDateTime;
import java.util.List;

import model.enums.KnownLanguages;
import model.enums.Role;

public class Admin extends User {

	private String department;
	private Admin supervisor;
	private Double salary;

	public Admin(User user, String department, Admin supervisor, Double salary) {
		super(user.getFirstName(), user.getLastName(), user.getDob(), user.getContactNo(), user.getEmail(),
				user.getKnownLanguages(), user.getPassword(), user.getRole());
		this.department = department;
		this.supervisor = supervisor;
		this.salary = salary;
	}

	public Admin(String firstName, String lastName, LocalDateTime dob, String contactNo, String email,
			List<KnownLanguages> knownLanguages, String password, Role role, String department, Admin supervisor,
			Double salary) {
		super(firstName, lastName, dob, contactNo, email, knownLanguages, password, role);
		this.department = department;
		this.supervisor = supervisor;
		this.salary = salary;
	}

	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * @return the supervisor
	 */
	public Admin getSupervisor() {
		return supervisor;
	}

	/**
	 * @param supervisor the supervisor to set
	 */
	public void setSupervisor(Admin supervisor) {
		this.supervisor = supervisor;
	}

	/**
	 * @return the salary
	 */
	public Double getSalary() {
		return salary;
	}

	/**
	 * @param salary the salary to set
	 */
	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Admin [department=").append(department).append(", supervisor=").append(supervisor)
				.append(", salary=").append(salary).append("]");
		return builder.toString();
	}
}
