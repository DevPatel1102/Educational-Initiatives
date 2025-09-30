package com.devpatel.designpatterns.structural.adapter;

public class AdapterDemo {
    public static void run() {
        System.out.println("=== Adapter Pattern: Temperature Adapter Demo ===");
        LegacyFahrenheitService legacy = new LegacyFahrenheitService();
        TemperatureSensor sensor = new FahrenheitToCelsiusAdapter(legacy);
        System.out.printf("Temperature (C): %.2f\n", sensor.getTemperatureCelsius());
        System.out.println("Demo finished.");
    }
}
