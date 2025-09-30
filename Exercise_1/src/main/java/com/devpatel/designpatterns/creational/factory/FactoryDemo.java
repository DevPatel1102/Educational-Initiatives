package com.devpatel.designpatterns.creational.factory;

public class FactoryDemo {
    public static void run() {
        System.out.println("=== Factory Pattern: NotificationFactory Demo ===");
        Notification n1 = NotificationFactory.create("email");
        n1.send("user@example.com", "Hello via Email!");

        Notification n2 = NotificationFactory.create("sms");
        n2.send("+919900112233", "Hello via SMS!");

        System.out.println("Demo finished.");
    }
}
