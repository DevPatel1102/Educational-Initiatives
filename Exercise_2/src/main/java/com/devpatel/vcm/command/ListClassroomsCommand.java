package com.devpatel.vcm.command;

import com.devpatel.vcm.manager.ClassroomManager;
import com.devpatel.vcm.model.Classroom;

public class ListClassroomsCommand implements Command {
    private final ClassroomManager manager = ClassroomManager.getInstance();
    @Override
    public void execute(String[] args) {
        System.out.println("Classrooms:");
        for (Classroom c : manager.listClassrooms()) {
            System.out.println(" - " + c.getName());
        }
    }
    @Override public String name() { return "list_classrooms"; }
    @Override public String description() { return "List all classrooms"; }
}
