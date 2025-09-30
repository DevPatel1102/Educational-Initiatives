package com.devpatel.designpatterns.structural.decorator;

import java.nio.file.*;
import java.nio.charset.StandardCharsets;

public class FileDataSource implements DataSource {
    private final Path path;

    public FileDataSource(String filename) {
        this.path = Paths.get(filename);
    }

    @Override
    public void writeData(String data) throws Exception {
        Files.write(path, data.getBytes(StandardCharsets.UTF_8));
    }

    @Override
    public String readData() throws Exception {
        if (!Files.exists(path)) return "";
        return Files.readString(path, StandardCharsets.UTF_8);
    }
}
