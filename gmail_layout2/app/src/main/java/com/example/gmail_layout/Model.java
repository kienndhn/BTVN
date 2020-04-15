package com.example.gmail_layout;

public class Model {
    String name;
    String subtitle;
    String content;

    public Model(String name, String subtitle, String content) {
        this.name = name;
        this.subtitle = subtitle;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
