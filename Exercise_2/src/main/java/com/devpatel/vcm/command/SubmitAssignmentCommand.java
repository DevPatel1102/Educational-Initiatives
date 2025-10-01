package com.devpatel.vcm.command;

import com.devpatel.vcm.manager.ClassroomManager;

public class SubmitAssignmentCommand implements Command {
    private final ClassroomManager manager = ClassroomManager.getInstance();
    @Override
    public void execute(String[] args) {
        if (args.length < 4) { System.out.println("Usage: submit_assignment <studentId> <className> <assignmentTitle>"); return; }
        String studentId = args[1];
        String className = args[2];
        String title = String.join(" ", java.util.Arrays.copyOfRange(args, 3, args.length));
        try {
            manager.submitAssignment(studentId, className, title);
            System.out.println("Assignment submitted by Student ["+studentId+"] in ["+className+"].");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    @Override public String name() { return "submit_assignment"; }
    @Override public String description() { return "Submit assignment for a student"; }
}
