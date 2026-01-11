package com.novacomp.notifications.core.model;

import java.time.Instant;
import java.util.Optional;

public final class NotificationResult {

    public enum Status {
        SUCCESS,
        FAILED,
        RETRYABLE
    }

    private final Status status;
    private final String provider;
    private final String externalId;
    private final String errorMessage;
    private final Instant timestamp;

    private NotificationResult(Status status,
                               String provider,
                               String externalId,
                               String errorMessage) {
        this.status = status;
        this.provider = provider;
        this.externalId = externalId;
        this.errorMessage = errorMessage;
        this.timestamp = Instant.now();
    }

    public static NotificationResult success(String provider, String externalId) {
        return new NotificationResult(Status.SUCCESS, provider, externalId, null);
    }

    public static NotificationResult failed(String provider, String errorMessage) {
        return new NotificationResult(Status.FAILED, provider, null, errorMessage);
    }

    public static NotificationResult retryable(String provider, String errorMessage) {
        return new NotificationResult(Status.RETRYABLE, provider, null, errorMessage);
    }

    public Status status() {
        return status;
    }

    public Optional<String> errorMessage() {
        return Optional.ofNullable(errorMessage);
    }

    public Instant timestamp() {
        return timestamp;
    }
}
