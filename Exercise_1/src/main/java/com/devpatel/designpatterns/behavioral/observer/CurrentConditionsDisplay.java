package com.devpatel.designpatterns.behavioral.observer;

public class CurrentConditionsDisplay implements Observer {
    private final String name;

    public CurrentConditionsDisplay(String name) { this.name = name; }

    @Override
    public void update(double temperatureCelsius) {
        System.out.printf("[%s] Current temp: %.2f C\n", name, temperatureCelsius);
    }
}
