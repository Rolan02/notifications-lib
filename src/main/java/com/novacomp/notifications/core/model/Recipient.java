package com.novacomp.notifications.core.model;

import java.util.Objects;

public class Recipient {

    private final String value;

    private Recipient(String value) {
        this.value = Objects.requireNonNull(value);
    }

    public static Recipient of(String value) {
        return new Recipient(value);
    }

    public String value() {
        return value;
    }
}
