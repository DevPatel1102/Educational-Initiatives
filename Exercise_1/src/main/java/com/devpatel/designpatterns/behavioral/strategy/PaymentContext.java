package com.devpatel.designpatterns.behavioral.strategy;

import java.util.Objects;

public class PaymentContext {
    private PaymentStrategy strategy;

    public PaymentContext(PaymentStrategy strategy) {
        this.strategy = Objects.requireNonNull(strategy);
    }

    public void setStrategy(PaymentStrategy strategy) {
        this.strategy = Objects.requireNonNull(strategy);
    }

    public void payAmount(double amount) {
        strategy.pay(amount);
    }
}
