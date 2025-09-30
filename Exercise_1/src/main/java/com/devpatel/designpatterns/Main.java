package com.devpatel.designpatterns;

import com.devpatel.designpatterns.util.LoggerUtil;
import com.devpatel.designpatterns.util.ConfigManager;
import java.util.Scanner;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = LoggerUtil.getLogger();

    public static void main(String[] args) {
        logger.info("Starting DesignPatterns demo");
        ConfigManager cfg = ConfigManager.getInstance();
        logger.info("App name: " + cfg.get("app.name", "DesignPatternsDemo"));

        Scanner scanner = new Scanner(System.in);
        String choice = null;
        do {
            System.out.println("\n=== Design Patterns Demo Menu ===");
            System.out.println("1) Strategy pattern - Payment processing");
            System.out.println("2) Observer pattern - WeatherStation");
            System.out.println("3) Factory pattern - NotificationFactory");
            System.out.println("4) Builder pattern - Report Builder");
            System.out.println("5) Adapter pattern - Temperature Adapter");
            System.out.println("6) Decorator pattern - DataSource Encryption");
            System.out.println("0) Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextLine().trim();
            try {
                switch (choice) {
                    case "1": com.devpatel.designpatterns.behavioral.strategy.PaymentDemo.run(scanner); break;
                    case "2": com.devpatel.designpatterns.behavioral.observer.WeatherDemo.run(); break;
                    case "3": com.devpatel.designpatterns.creational.factory.FactoryDemo.run(); break;
                    case "4": com.devpatel.designpatterns.creational.builder.BuilderDemo.run(); break;
                    case "5": com.devpatel.designpatterns.structural.adapter.AdapterDemo.run(); break;
                    case "6": com.devpatel.designpatterns.structural.decorator.DecoratorDemo.run(); break;
                    case "0": System.out.println("Exiting. Goodbye!"); break;
                    default: System.out.println("Unknown option. Please try again."); break;
                }
            } catch (Exception e) {
                logger.severe("An error occurred while running the demo: " + e.getMessage());
                e.printStackTrace();
            }
        } while (!"0".equals(choice));

        scanner.close();
        logger.info("DesignPatterns demo terminated");
    }
}
