import model.entity.User;
import model.enums.Role;
import view.login.LoginView;

public class TourEasy {
	public static void main(String[] args) {
//        System.out.println("Hello, we will use this as the main class which will call others!!");
//
//        Scanner scanner = new Scanner(System.in);
//        while (true) {
//            System.out.println("===== TourEasy Menu =====");
//            System.out.println("1. View Tours");
//            System.out.println("2. Profile");
//            System.out.println("3. Exit");
//            System.out.print("Enter your choice: ");
//
//            int choice = scanner.nextInt();
//            scanner.nextLine();  // Consume the newline character
//
//            switch (choice) {
//                case 1:
//                    System.out.println("You selected Option 1");
//                    // Add logic here
//                    break;
//                case 2:
//                    System.out.println("You selected Option 2");
//                    // Add logic here
//                    break;
//                case 3:
//                    System.out.println("Exiting the program. Goodbye!");
//                    System.exit(0);
//                default:
//                    System.out.println("Invalid choice. Please enter a valid option.");
//            }
//        }
//
//    }

		while (true) {
			User loggedInUser = LoginView.login();
			if (loggedInUser == null) {
				continue;
			}

			// Authenticated user
			if (Role.GUIDE.equals(loggedInUser.getRole())) {
				System.out.println("Hi guide");
			} else if (Role.CUSTOMER.equals(loggedInUser.getRole())) {
				System.out.println("Hello customer");
			}
		}

	}
}