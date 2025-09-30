package com.devpatel.designpatterns.structural.decorator;

public class DecoratorDemo {
    public static void run() {
        System.out.println("=== Decorator Pattern: DataSource Encryption Demo ===");
        String filename = "demo_data.txt";
        try {
            DataSource ds = new FileDataSource(filename);
            DataSource encrypted = new EncryptionDecorator(ds);

            String secret = "Top secret data: API_KEY=XYZ123";
            encrypted.writeData(secret);
            System.out.println("Wrote encrypted data to file.");

            String read = encrypted.readData();
            System.out.println("Decrypted read: " + read);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Demo finished.");
    }
}
