package com.devpatel.designpatterns.creational.factory;

import com.devpatel.designpatterns.util.LoggerUtil;

public class SmsNotification implements Notification {
    @Override
    public void send(String to, String message) {
        LoggerUtil.getLogger().info("Sending SMS to " + to + ": " + message);
    }
}
