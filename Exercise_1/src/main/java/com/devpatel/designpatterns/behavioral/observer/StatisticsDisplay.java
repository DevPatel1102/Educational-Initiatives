package com.devpatel.designpatterns.behavioral.observer;

public class StatisticsDisplay implements Observer {
    private double max = Double.MIN_VALUE;
    private double min = Double.MAX_VALUE;
    private double sum = 0;
    private int count = 0;

    @Override
    public void update(double temperatureCelsius) {
        count++;
        sum += temperatureCelsius;
        max = Math.max(max, temperatureCelsius);
        min = Math.min(min, temperatureCelsius);
        System.out.printf("[Stats] avg=%.2f max=%.2f min=%.2f\n", sum / count, max, min);
    }
}
