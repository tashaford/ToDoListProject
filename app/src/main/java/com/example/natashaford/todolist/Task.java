package com.example.natashaford.todolist;

public class Task{

    private int id;
    private String title;
    private String details;
    private boolean completed;
    private String category;
    private boolean priority;

    public Task(){
    }

    public Task(int id, String title, String details, boolean completed, String category, boolean priority){
        this.id = id;
        this.title = title;
        this.details = details;
        this.completed = completed;
        this.category = category;
        this.priority = priority;
    }

    public Task(String title, String details, boolean completed, String category, boolean priority){
        this.title = title;
        this.details = details;
        this.completed = completed;
        this.category = category;
        this.priority = priority;
    }

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getTitle() {return title;}

    public void setTitle(String title) {this.title = title;}

    public String getDetails() {return details;}

    public void setDetails(String details) {this.details = details;}

    public boolean getCompleted(){return completed;}

    public void setCompleted(boolean completed){this.completed = completed;}

    public String getCategory(){return category;}

    public void setCategory(String priority){this.category = priority;}

    public boolean getPriority() {return priority;}

    public void setPriority(boolean priority) {this.priority = priority;}
}