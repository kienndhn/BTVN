package com.example.gmail_layout;

public class ContactModel {
    String name;
    String subtitle;
    String content;
    boolean isSelected;

    public ContactModel(String name, String subtitle, String content) {
        this.name = name;
        this.subtitle = subtitle;
        this.content = content;
        this.isSelected = false;
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

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
