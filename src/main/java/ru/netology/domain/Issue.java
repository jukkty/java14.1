package ru.netology.domain;


public class Issue {
    private final int id;
    private final String name;
    private boolean open;
    private final String author;
    private final String assignee;
    private final String label;

    public Issue(int id, String name, boolean open, String author, String assignee, String label) {
        this.id = id;
        this.name = name;
        this.open = open;
        this.author = author;
        this.assignee = assignee;
        this.label = label;
    }

    public int getId() {
        return id;
    }


    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public String getAuthor() {
        return author;
    }


    public String getAssignee() {
        return assignee;
    }


    public String getLabel() {
        return label;
    }


    @Override
    public String toString() {
        return "Issue{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", open=" + open +
                ", author='" + author + '\'' +
                ", assignee='" + assignee + '\'' +
                ", label='" + label + '\'' +
                '}';
    }
}
