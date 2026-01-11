package com.novacomp.notifications.channel.sms;

import com.novacomp.notifications.core.channel.NotificationChannel;
import com.novacomp.notifications.core.model.Notification;
import com.novacomp.notifications.core.model.NotificationResult;
import com.novacomp.notifications.validation.NotificationValidator;

import java.util.Objects;

public class SmsChannel implements NotificationChannel {

    private final SmsProvider provider;
    private final NotificationValidator validator;

    public SmsChannel(SmsProvider provider,
                      NotificationValidator validator) {
        this.provider = Objects.requireNonNull(provider);
        this.validator = Objects.requireNonNull(validator);
    }

    @Override
    public String name() {
        return "SMS";
    }

    @Override
    public NotificationResult send(Notification notification) {
        validator.validate(notification);
        return provider.send(notification);
    }
}
