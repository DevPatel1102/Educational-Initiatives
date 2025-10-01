package com.devpatel.vcm.command;

import com.devpatel.vcm.manager.ClassroomManager;

public class RemoveClassroomCommand implements Command {
    private final ClassroomManager manager = ClassroomManager.getInstance();
    @Override
    public void execute(String[] args) {
        if (args.length < 2) { System.out.println("Usage: remove_classroom <className>"); return; }
        String name = args[1];
        boolean ok = manager.removeClassroom(name);
        if (ok) System.out.println("Classroom ["+name+"] removed."); else System.out.println("No such classroom: " + name);
    }
    @Override public String name() { return "remove_classroom"; }
    @Override public String description() { return "Remove a classroom"; }
}
