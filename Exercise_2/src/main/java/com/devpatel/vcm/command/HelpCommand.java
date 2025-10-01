package com.devpatel.vcm.command;

import java.util.*;

public class HelpCommand implements Command {
    private final List<Command> commands;
    public HelpCommand(List<Command> commands) { this.commands = commands; }
    @Override public void execute(String[] args) {
        System.out.println("Available commands:");
        for (Command c : commands) {
            System.out.printf(" - %s : %s\n", c.name(), c.description());
        }
    }
    @Override public String name() { return "help"; }
    @Override public String description() { return "Show help"; }
}
