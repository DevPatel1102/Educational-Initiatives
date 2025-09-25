package com.devpatel.designpatterns.behavioral.strategy;

import com.devpatel.designpatterns.util.LoggerUtil;
import java.util.logging.Logger;
import java.util.Objects;

public class CreditCardPayment implements PaymentStrategy {
    private final Logger logger = LoggerUtil.getLogger();
    private final String cardNumber;
    private final String cardHolder;

    public CreditCardPayment(String cardNumber, String cardHolder) {
        this.cardNumber = Objects.requireNonNull(cardNumber);
        this.cardHolder = Objects.requireNonNull(cardHolder);
    }

    @Override
    public void pay(double amount) {
        logger.info(String.format("Processing credit card payment for %s: $%.2f", cardHolder, amount));
        // Simulate transient error handling (retry once)
        try {
            processPayment(amount);
            logger.info("Credit card payment successful");
        } catch (RuntimeException e) {
            logger.warning("Transient error occurred, retrying once: " + e.getMessage());
            processPayment(amount); // simple retry for demo
        }
    }

    private void processPayment(double amount) {
        if (amount < 0) throw new IllegalArgumentException("Amount cannot be negative");
        // Simulate processing
    }
}
