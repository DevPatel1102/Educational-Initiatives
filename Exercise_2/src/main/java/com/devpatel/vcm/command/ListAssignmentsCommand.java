package com.devpatel.vcm.command;

import com.devpatel.vcm.manager.ClassroomManager;
import com.devpatel.vcm.model.Classroom;
import com.devpatel.vcm.model.Assignment;

public class ListAssignmentsCommand implements Command {
    private final ClassroomManager manager = ClassroomManager.getInstance();
    @Override
    public void execute(String[] args) {
        if (args.length < 2) { System.out.println("Usage: list_assignments <className>"); return; }
        String className = args[1];
        Classroom c = manager.getClassroom(className).orElse(null);
        if (c == null) { System.out.println("Classroom not found: " + className); return; }
        System.out.println("Assignments in " + className + ":");
        for (Assignment a : c.getAssignments()) {
            System.out.println(" - " + a.getTitle() + " (scheduled at: " + a.getScheduledAt() + ")");
        }
    }
    @Override public String name() { return "list_assignments"; }
    @Override public String description() { return "List assignments for classroom"; }
}
