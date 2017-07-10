package com.example.natashaford.todolist;

/**
 * Created by natashaford on 07/07/2017.
 */

public class Task{

    private int id;
    private String title;
    private String details;

    public Task(){

    }

    public Task(int id, String title, String details){
        this.id = id;
        this.title = title;
        this.details = details;
    }

    public Task(String title, String details){
        this.title = title;
        this.details = details;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }


}
