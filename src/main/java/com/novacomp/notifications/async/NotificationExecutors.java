package com.novacomp.notifications.async;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public final class NotificationExecutors {

    private NotificationExecutors() {
    }

    public static Executor defaultExecutor() {
        return Executors.newFixedThreadPool(
                Runtime.getRuntime().availableProcessors()
        );
    }
}
