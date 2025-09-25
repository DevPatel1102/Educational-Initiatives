package com.devpatel.designpatterns.behavioral.strategy;

import java.util.Scanner;

public class PaymentDemo {
    public static void run(Scanner scanner) {
        System.out.println("=== Strategy Pattern: Payment Demo ===");
        System.out.print("Enter payment amount: ");
        String line = scanner.nextLine().trim();
        double amount = 0;
        try {
            amount = Double.parseDouble(line);
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount. Aborting demo.");
            return;
        }

        System.out.println("Choose payment method: 1) Credit Card  2) UPI");
        String opt = scanner.nextLine().trim();
        PaymentContext ctx;
        if ("1".equals(opt)) {
            ctx = new PaymentContext(new CreditCardPayment("4111111111111111","Dev Patel"));
        } else {
            ctx = new PaymentContext(new UPIPayment("dev@upi"));
        }
        ctx.payAmount(amount);
        System.out.println("Demo finished."); 
    }
}
