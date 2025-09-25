package com.devpatel.designpatterns.util;

import java.util.Properties;
import java.io.*;

public final class ConfigManager {
    private static volatile ConfigManager instance;
    private final Properties props = new Properties();

    private ConfigManager() {
        load();
    }

    public static ConfigManager getInstance() {
        if (instance == null) {
            synchronized (ConfigManager.class) {
                if (instance == null) instance = new ConfigManager();
            }
        }
        return instance;
    }

    private void load() {
        try (InputStream in = new FileInputStream("config.properties")) {
            props.load(in);
            LoggerUtil.getLogger().info("Loaded config.properties");
        } catch (FileNotFoundException e) {
            LoggerUtil.getLogger().warning("config.properties not found, using defaults");
            props.setProperty("app.name", "DesignPatternsDemo");
        } catch (IOException e) {
            LoggerUtil.getLogger().warning("Error loading config.properties: " + e.getMessage());
        }
    }

    public String get(String key, String defaultValue) {
        return props.getProperty(key, defaultValue);
    }
}
