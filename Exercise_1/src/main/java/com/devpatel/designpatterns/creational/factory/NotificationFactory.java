package com.devpatel.designpatterns.creational.factory;

public class NotificationFactory {
    public static Notification create(String type) {
        if (type == null) throw new IllegalArgumentException("type cannot be null");
        switch (type.toLowerCase()) {
            case "email": return new EmailNotification();
            case "sms": return new SmsNotification();
            default: throw new IllegalArgumentException("Unknown notification type: " + type);
        }
    }
}
