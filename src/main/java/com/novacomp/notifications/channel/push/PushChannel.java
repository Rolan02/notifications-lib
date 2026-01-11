package com.novacomp.notifications.channel.push;

import com.novacomp.notifications.core.channel.NotificationChannel;
import com.novacomp.notifications.core.model.Notification;
import com.novacomp.notifications.core.model.NotificationResult;
import com.novacomp.notifications.validation.NotificationValidator;

import java.util.Objects;

public class PushChannel implements NotificationChannel {

    private final PushProvider provider;
    private final NotificationValidator validator;

    public PushChannel(PushProvider provider,
                       NotificationValidator validator) {
        this.provider = Objects.requireNonNull(provider);
        this.validator = Objects.requireNonNull(validator);
    }

    @Override
    public String name() {
        return "PUSH";
    }

    @Override
    public NotificationResult send(Notification notification) {
        validator.validate(notification);
        return provider.send(notification);
    }
}
