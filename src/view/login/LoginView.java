package view.login;

import java.util.Scanner;

public class LoginView {

	public static String getUserNameInput() {
		System.out.println("✦•······················•✦•······················•✦");
		System.out.println("Please login with your registered credentials");

		Scanner scanner = new Scanner(System.in);

		System.out.println("Email Id: ");
		String email = scanner.nextLine();
		return email;
	}

	public static String getPasswordInput() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Password: ");
		String password = scanner.nextLine();
		return password;
	}
}
