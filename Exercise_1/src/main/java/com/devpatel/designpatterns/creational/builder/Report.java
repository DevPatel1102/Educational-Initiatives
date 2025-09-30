package com.devpatel.designpatterns.creational.builder;

public class Report {
    private final String title;
    private final String content;
    private final String author;
    private final String footer;

    public Report(String title, String content, String author, String footer) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.footer = footer;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Title: ").append(title).append("\n");
        sb.append("Author: ").append(author).append("\n\n");
        sb.append(content).append("\n\n");
        sb.append(footer);
        return sb.toString();
    }
}
