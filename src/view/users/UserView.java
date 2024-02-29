package view.users;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import model.entity.User;
import model.enums.KnownLanguages;

public class UserView {

	public static void promptToEditProfile(User loggedInUser) {
		System.out.println(
				loggedInUser.getFirstName() + ", you can only update your Contact Number, and Known Languages");
	}

	public static String getContactNoInput() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Contact No: ");
		String contactNo = scanner.nextLine();
		return contactNo;
	}

	public static List<KnownLanguages> getKnownLanguagesInput() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Known Languages (space separated): ");
		String knownLanguagesInp = scanner.nextLine();
		String[] knownLanguagesStr = knownLanguagesInp.split(" ");
		ArrayList<String> knownLanguagesSt = new ArrayList<>(Arrays.asList(knownLanguagesStr));
		List<KnownLanguages> knownLanguages = knownLanguagesSt.stream().map(kl -> KnownLanguages.fromString(kl))
				.collect(Collectors.toList());
		return knownLanguages;
	}
}
