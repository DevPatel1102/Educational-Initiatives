package com.devpatel.designpatterns.behavioral.observer;

public class WeatherDemo {
    public static void run() {
        System.out.println("=== Observer Pattern: WeatherStation Demo ===");
        WeatherStation station = new WeatherStation();
        station.register(new CurrentConditionsDisplay("Lobby"));
        station.register(new CurrentConditionsDisplay("Rooftop"));
        station.register(new StatisticsDisplay());

        double[] readings = { 25.2, 26.1, 24.8, 27.0 };
        for (double r : readings) {
            System.out.println("Setting temperature to " + r);
            station.setTemperature(r);
            // small pause intentionally omitted for demo speed
        }
        System.out.println("Demo finished.");
    }
}
