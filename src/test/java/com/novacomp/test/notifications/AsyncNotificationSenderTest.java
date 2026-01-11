package com.novacomp.test.notifications;

import com.novacomp.notifications.async.AsyncNotificationSender;
import com.novacomp.notifications.core.model.Notification;
import com.novacomp.notifications.core.model.NotificationResult;
import com.novacomp.notifications.core.sender.NotificationSender;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class AsyncNotificationSenderTest {

    @Test
    void shouldSendNotificationAsync() {
        NotificationSender sender = mock(NotificationSender.class);
        Notification notification = mock(Notification.class);

        when(sender.send(notification))
                .thenReturn(NotificationResult.success("Mock", "id"));

        AsyncNotificationSender asyncSender =
                new AsyncNotificationSender(sender, Executors.newSingleThreadExecutor());

        CompletableFuture<NotificationResult> future =
                asyncSender.sendAsync(notification);

        NotificationResult result = future.join();

        assertEquals(NotificationResult.Status.SUCCESS, result.status());
        verify(sender).send(notification);
    }
}
