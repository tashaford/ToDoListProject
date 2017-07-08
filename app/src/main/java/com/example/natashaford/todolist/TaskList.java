package com.example.natashaford.todolist;

import java.util.ArrayList;

/**
 * Created by natashaford on 07/07/2017.
 */

public class TaskList {
    private ArrayList<Task> list;

    public TaskList() {
        list = new ArrayList<Task>();
        list.add(new Task("Example title","Example details"));
        list.add(new Task("Second example", "More details"));
        list.add(new Task("Another example", "Even more details"));
        list.add(new Task("One more example", "Just a bit more details"));

    }

    public ArrayList<Task> getList(){
        return new ArrayList<Task>(list);
    }

    public void addToList(Task task){
        list.add(task);
    }


}
