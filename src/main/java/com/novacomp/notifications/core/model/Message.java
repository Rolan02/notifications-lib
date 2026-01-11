package com.novacomp.notifications.core.model;

import java.util.Objects;

public class Message {

    private final String title;
    private final String body;

    private Message(String title, String body) {
        this.title = title;
        this.body = Objects.requireNonNull(body);
    }

    public static Message of(String body) {
        return new Message(null, body);
    }

    public static Message of(String title, String body) {
        return new Message(title, body);
    }

    public String title() {
        return title;
    }

    public String body() {
        return body;
    }
}
