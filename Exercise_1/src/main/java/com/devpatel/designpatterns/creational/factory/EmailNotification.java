package com.devpatel.designpatterns.creational.factory;

import com.devpatel.designpatterns.util.LoggerUtil;

public class EmailNotification implements Notification {
    @Override
    public void send(String to, String message) {
        LoggerUtil.getLogger().info("Sending EMAIL to " + to + ": " + message);
        // Simulate sending
    }
}
