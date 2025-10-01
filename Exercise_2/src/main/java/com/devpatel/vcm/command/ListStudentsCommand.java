package com.devpatel.vcm.command;

import com.devpatel.vcm.manager.ClassroomManager;
import com.devpatel.vcm.model.Classroom;
import com.devpatel.vcm.model.Student;

public class ListStudentsCommand implements Command {
    private final ClassroomManager manager = ClassroomManager.getInstance();
    @Override
    public void execute(String[] args) {
        if (args.length < 2) { System.out.println("Usage: list_students <className>"); return; }
        String className = args[1];
        Classroom c = manager.getClassroom(className).orElse(null);
        if (c == null) { System.out.println("Classroom not found: " + className); return; }
        System.out.println("Students in " + className + ":");
        for (Student s : c.getStudents()) {
            System.out.println(" - " + s.getId());
        }
    }
    @Override public String name() { return "list_students"; }
    @Override public String description() { return "List students in a classroom"; }
}
