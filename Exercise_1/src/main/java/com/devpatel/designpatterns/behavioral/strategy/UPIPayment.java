package com.devpatel.designpatterns.behavioral.strategy;

import com.devpatel.designpatterns.util.LoggerUtil;
import java.util.logging.Logger;
import java.util.Objects;

public class UPIPayment implements PaymentStrategy {
    private final Logger logger = LoggerUtil.getLogger();
    private final String upiId;

    public UPIPayment(String upiId) {
        this.upiId = Objects.requireNonNull(upiId);
    }

    @Override
    public void pay(double amount) {
        logger.info(String.format("Processing UPI payment for %s: $%.2f", upiId, amount));
        // Simulate success
    }
}
