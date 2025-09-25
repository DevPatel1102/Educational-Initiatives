package com.devpatel.designpatterns.behavioral.observer;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.List;

public class WeatherStation implements Subject {
    private final List<Observer> observers = new CopyOnWriteArrayList<>();
    private double temperatureCelsius;

    @Override
    public void register(Observer o) {
        observers.add(o);
    }

    @Override
    public void unregister(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(temperatureCelsius);
        }
    }

    public void setTemperature(double tempC) {
        this.temperatureCelsius = tempC;
        notifyObservers();
    }
}
