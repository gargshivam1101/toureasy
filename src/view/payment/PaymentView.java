package view.payment;

import model.entity.PaymentInfo;
import model.enums.PaymentMode;

import java.util.Scanner;

public class PaymentView {

    public PaymentInfo promptForPaymentInfo() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Billing Name: ");
        String billingName = scanner.nextLine();

        System.out.println("Enter Billing Address: ");
        String billingAddress = scanner.nextLine();

        PaymentMode preferredModeOfPayment = promptForPaymentMode();

        if (preferredModeOfPayment == PaymentMode.CARD) {
            System.out.println("Enter Card Details: ");
            String cardDetails = scanner.nextLine();
            return new PaymentInfo(billingName, billingAddress, PaymentMode.CARD, null, cardDetails);
        } else if (preferredModeOfPayment == PaymentMode.WALLET) {
            return new PaymentInfo(billingName, billingAddress, PaymentMode.WALLET, null, null);
        } else {
            return null;
        }
    }

    private PaymentMode promptForPaymentMode() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose Payment Mode:");
        System.out.println("1. Card");
        System.out.println("2. Wallet");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                return PaymentMode.CARD;
            case 2:
                return PaymentMode.WALLET;
            default:
                System.out.println("Invalid choice. Defaulting to Card.");
                return PaymentMode.CARD;
        }
    }
}
