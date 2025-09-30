package com.devpatel.designpatterns.structural.adapter;

public class FahrenheitToCelsiusAdapter implements TemperatureSensor {
    private final LegacyFahrenheitService legacy;

    public FahrenheitToCelsiusAdapter(LegacyFahrenheitService legacy) {
        this.legacy = legacy;
    }

    @Override
    public double getTemperatureCelsius() {
        double f = legacy.getTemperatureFahrenheit();
        return (f - 32) * 5.0 / 9.0;
    }
}
