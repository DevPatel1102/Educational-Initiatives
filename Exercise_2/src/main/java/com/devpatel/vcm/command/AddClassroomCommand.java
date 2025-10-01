package com.devpatel.vcm.command;

import com.devpatel.vcm.manager.ClassroomManager;

public class AddClassroomCommand implements Command {
    private final ClassroomManager manager = ClassroomManager.getInstance();

    @Override
    public void execute(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: add_classroom <className>"); return;
        }
        String name = args[1];
        manager.createClassroom(name);
        System.out.println("Classroom [" + name + "] has been created.");
    }

    @Override public String name() { return "add_classroom"; }
    @Override public String description() { return "Create a new classroom"; }
}
