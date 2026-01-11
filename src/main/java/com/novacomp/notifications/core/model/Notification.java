package com.novacomp.notifications.core.model;

import com.novacomp.notifications.core.channel.NotificationChannel;

import java.util.Map;
import java.util.Objects;

public final class Notification {

    private final NotificationChannel channel;
    private final Recipient recipient;
    private final Message message;
    private final Map<String, Object> metadata;

    private Notification(Builder builder) {
        this.channel = Objects.requireNonNull(builder.channel);
        this.recipient = Objects.requireNonNull(builder.recipient);
        this.message = Objects.requireNonNull(builder.message);
        this.metadata = builder.metadata;
    }

    public NotificationChannel channel() {
        return channel;
    }

    public Recipient recipient() {
        return recipient;
    }

    public Message message() {
        return message;
    }

    public Map<String, Object> metadata() {
        return metadata;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private NotificationChannel channel;
        private Recipient recipient;
        private Message message;
        private Map<String, Object> metadata = Map.of();

        public Builder channel(NotificationChannel channel) {
            this.channel = channel;
            return this;
        }

        public Builder recipient(Recipient recipient) {
            this.recipient = recipient;
            return this;
        }

        public Builder message(Message message) {
            this.message = message;
            return this;
        }

        public Builder metadata(Map<String, Object> metadata) {
            this.metadata = metadata;
            return this;
        }

        public Notification build() {
            return new Notification(this);
        }
    }
}
