package com.novacomp.notifications.config;

import com.novacomp.notifications.core.channel.NotificationChannel;
import com.novacomp.notifications.core.exception.NotificationException;
import com.novacomp.notifications.core.model.Notification;
import com.novacomp.notifications.core.model.NotificationResult;

import java.util.Map;
import java.util.Objects;

public class NotificationClient {

    private final Map<String, NotificationChannel> channels;

    public NotificationClient(Map<String, NotificationChannel> channels) {
        this.channels = channels;
    }

    public NotificationResult send(Notification notification) {
        Objects.requireNonNull(notification, "Notification must not be null");

        String channelName = notification.channel().name();
        NotificationChannel channel = channels.get(channelName);

        if (channel == null) {
            throw new NotificationException("No channel configured for: " + channelName);
        }

        return channel.send(notification);
    }

    public static NotificationClientBuilder builder() {
        return new NotificationClientBuilder();
    }
}
