package com.novacomp.notifications.validation;

import com.novacomp.notifications.core.exception.NotificationValidationException;
import com.novacomp.notifications.core.model.Notification;

/**
 * Contract for validating notifications.
 * Each channel must provide its own implementation.
 */
@FunctionalInterface
public interface NotificationValidator {

    /**
     * Validates the given notification.
     *
     * @param notification notification to validate
     * @throws NotificationValidationException if validation fails
     */
    void validate(Notification notification)
            throws NotificationValidationException;
}
