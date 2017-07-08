package com.example.natashaford.todolist;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class FullListActivity extends menuClass implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_list);

        TaskList taskList = new TaskList();
        ArrayList<Task> list = taskList.getList();

        TaskListAdapter tasksAdapter = new TaskListAdapter(this, list);

        ListView listView = (ListView) findViewById(R.id.tasks_list);
        listView.setAdapter(tasksAdapter);
    }

    public void getTask(View listItem) {
        Task task = (Task) listItem.getTag();
        Log.d("Task title: ", task.getTitle());
        Intent intent = new Intent(this, TaskActivity.class);
        startActivity(intent);
    }

    public void onClick(View v) {

    }

}
