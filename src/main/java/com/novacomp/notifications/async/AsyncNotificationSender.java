package com.novacomp.notifications.async;

import com.novacomp.notifications.core.model.Notification;
import com.novacomp.notifications.core.model.NotificationResult;
import com.novacomp.notifications.core.sender.NotificationSender;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

public class AsyncNotificationSender {

    private final NotificationSender delegate;
    private final Executor executor;

    public AsyncNotificationSender(NotificationSender delegate,
                                   Executor executor) {
        this.delegate = Objects.requireNonNull(delegate);
        this.executor = Objects.requireNonNull(executor);
    }

    public CompletableFuture<NotificationResult> sendAsync(
            Notification notification) {

        return CompletableFuture.supplyAsync(
                () -> delegate.send(notification),
                executor
        );
    }
}
