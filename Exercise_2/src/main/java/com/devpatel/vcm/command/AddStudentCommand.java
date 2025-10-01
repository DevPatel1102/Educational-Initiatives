package com.devpatel.vcm.command;

import com.devpatel.vcm.manager.ClassroomManager;

public class AddStudentCommand implements Command {
    private final ClassroomManager manager = ClassroomManager.getInstance();
    @Override
    public void execute(String[] args) {
        if (args.length < 3) { System.out.println("Usage: add_student <studentId> <className>"); return; }
        String studentId = args[1];
        String className = args[2];
        try {
            manager.enrollStudent(studentId, className);
            System.out.println("Student ["+studentId+"] has been enrolled in ["+className+"].");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    @Override public String name() { return "add_student"; }
    @Override public String description() { return "Enroll student into classroom"; }
}
