package com.devpatel.designpatterns.creational.builder;

public class BuilderDemo {
    public static void run() {
        System.out.println("=== Builder Pattern: Report Builder Demo ===");
        Report report = new ReportBuilder()
                .withTitle("Monthly Sales Report")
                .withAuthor("Dev Patel")
                .withContent("Sales increased by 12% compared to last month. Key driver: X.")
                .withFooter("Confidential")
                .build();
        System.out.println(report);
        System.out.println("Demo finished.");
    }
}
