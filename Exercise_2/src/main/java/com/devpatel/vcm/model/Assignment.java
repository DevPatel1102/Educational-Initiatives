package com.devpatel.vcm.model;

import java.util.Objects;
import java.time.Instant;

public class Assignment {
    private final String title;
    private final Instant scheduledAt;

    public Assignment(String title) {
        this.title = Objects.requireNonNull(title, "assignment title required").trim();
        this.scheduledAt = Instant.now();
    }

    public String getTitle() { return title; }

    public Instant getScheduledAt() { return scheduledAt; }
}
