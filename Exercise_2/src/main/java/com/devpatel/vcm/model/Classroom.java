package com.devpatel.vcm.model;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Classroom {
    private final String name;
    private final Map<String, Student> students = new ConcurrentHashMap<>();
    private final Map<String, Assignment> assignments = new ConcurrentHashMap<>();

    public Classroom(String name) {
        this.name = Objects.requireNonNull(name, "class name required").trim();
    }

    public String getName() { return name; }

    public Collection<Student> getStudents() { return students.values(); }

    public void addStudent(Student s) {
        students.putIfAbsent(s.getId(), s);
    }

    public Student getStudent(String id) { return students.get(id); }

    public void removeStudent(String id) { students.remove(id); }

    public void addAssignment(Assignment a) {
        assignments.putIfAbsent(a.getTitle(), a);
    }

    public Assignment getAssignment(String title) { return assignments.get(title); }

    public Collection<Assignment> getAssignments() { return assignments.values(); }
}
