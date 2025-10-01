package com.devpatel.vcm.command;

public interface Command {
    void execute(String[] args);
    String name();
    String description();
}
