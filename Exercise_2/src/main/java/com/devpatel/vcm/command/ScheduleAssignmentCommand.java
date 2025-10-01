package com.devpatel.vcm.command;

import com.devpatel.vcm.manager.ClassroomManager;

public class ScheduleAssignmentCommand implements Command {
    private final ClassroomManager manager = ClassroomManager.getInstance();
    @Override
    public void execute(String[] args) {
        if (args.length < 3) { System.out.println("Usage: schedule_assignment <className> <assignmentTitle>"); return; }
        String className = args[1];
        String title = String.join(" ", java.util.Arrays.copyOfRange(args, 2, args.length));
        try {
            manager.scheduleAssignment(className, title);
            System.out.println("Assignment for ["+className+"] has been scheduled.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    @Override public String name() { return "schedule_assignment"; }
    @Override public String description() { return "Schedule assignment for classroom"; }
}
