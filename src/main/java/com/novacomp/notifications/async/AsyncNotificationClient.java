package com.novacomp.notifications.async;

import com.novacomp.notifications.config.NotificationClient;
import com.novacomp.notifications.core.model.Notification;
import com.novacomp.notifications.core.model.NotificationResult;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

public class AsyncNotificationClient {

    private final AsyncNotificationSender asyncSender;

    public AsyncNotificationClient(NotificationClient client,
                                   Executor executor) {
        this.asyncSender = new AsyncNotificationSender(
                client::send,
                executor
        );
    }

    public CompletableFuture<NotificationResult> sendAsync(
            Notification notification) {
        return asyncSender.sendAsync(notification);
    }
}
