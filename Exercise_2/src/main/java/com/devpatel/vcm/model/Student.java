package com.devpatel.vcm.model;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public class Student {
    private final String id;
    private final Map<String, Boolean> submissions = new ConcurrentHashMap<>();

    public Student(String id) {
        this.id = Objects.requireNonNull(id, "student id required").trim();
    }

    public String getId() { return id; }

    public void submit(String assignmentTitle) {
        submissions.put(assignmentTitle, true);
    }

    public boolean hasSubmitted(String assignmentTitle) {
        return submissions.getOrDefault(assignmentTitle, false);
    }
}
