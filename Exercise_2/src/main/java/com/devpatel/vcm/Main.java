package com.devpatel.vcm;

import com.devpatel.vcm.command.*;
import com.devpatel.vcm.util.LoggerUtil;

import java.util.*;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = LoggerUtil.getLogger();

    public static void main(String[] args) {
        logger.info("Starting Virtual Classroom Manager");
        CommandRegistry registry = new CommandRegistry();
        registry.register(new AddClassroomCommand());
        registry.register(new RemoveClassroomCommand());
        registry.register(new ListClassroomsCommand());
        registry.register(new AddStudentCommand());
        registry.register(new ListStudentsCommand());
        registry.register(new ScheduleAssignmentCommand());
        registry.register(new ListAssignmentsCommand());
        registry.register(new SubmitAssignmentCommand());

        // help command should know about registered commands. register last.
        registry.register(new HelpCommand(new ArrayList<>(registry.all())));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Virtual Classroom Manager — type 'help' for commands.");

        while (true) {
            System.out.print("> ");
            String line = scanner.nextLine();
            if (line == null) break;
            line = line.trim();
            if (line.isEmpty()) continue;
            if ("exit".equalsIgnoreCase(line) || "quit".equalsIgnoreCase(line)) { break; }
            String[] parts = line.split("\\s+");
            String cmdName = parts[0];
            Optional<Command> cmd = registry.get(cmdName);
            if (cmd.isPresent()) {
                try {
                    cmd.get().execute(parts);
                } catch (Exception e) {
                    logger.severe("Error executing command: " + e.getMessage());
                    System.out.println("An error occurred: " + e.getMessage());
                }
            } else {
                System.out.println("Unknown command: " + cmdName + ". Type 'help' to list commands."); 
            }
        }

        scanner.close();
        logger.info("VCM terminated");
        System.out.println("Goodbye!");
    }
}
