package com.devpatel.designpatterns.util;

import java.util.logging.*;

public class LoggerUtil {
    private static final Logger LOGGER = Logger.getLogger("DesignPatternsDemo");
    static {
        try {
            LogManager.getLogManager().reset();
            LOGGER.setLevel(Level.INFO);
            ConsoleHandler ch = new ConsoleHandler();
            ch.setLevel(Level.INFO);
            ch.setFormatter(new SimpleFormatter());
            LOGGER.addHandler(ch);
            FileHandler fh = new FileHandler("app.log", true);
            fh.setFormatter(new SimpleFormatter());
            fh.setLevel(Level.INFO);
            LOGGER.addHandler(fh);
        } catch (Exception e) {
            System.err.println("Logger initialization failed: " + e.getMessage());
        }
    }
    public static Logger getLogger() { return LOGGER; }
}
