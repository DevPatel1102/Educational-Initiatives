package com.devpatel.designpatterns.creational.builder;

import java.util.Objects;

public class ReportBuilder {
    private String title = "Untitled";
    private String content = "";
    private String author = "Anonymous";
    private String footer = "-- End of Report --";

    public ReportBuilder withTitle(String title) {
        this.title = Objects.requireNonNull(title);
        return this;
    }

    public ReportBuilder withContent(String content) {
        this.content = Objects.requireNonNull(content);
        return this;
    }

    public ReportBuilder withAuthor(String author) {
        this.author = Objects.requireNonNull(author);
        return this;
    }

    public ReportBuilder withFooter(String footer) {
        this.footer = Objects.requireNonNull(footer);
        return this;
    }

    public Report build() {
        return new Report(title, content, author, footer);
    }
}
