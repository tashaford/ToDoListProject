package com.example.natashaford.todolist;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ListView;

import java.util.ArrayList;

public class FullListActivity extends menuClass implements View.OnClickListener{

    private CheckBox box;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_list);

        box = (CheckBox) findViewById(R.id.checkBox);






        DatabaseHandler db = new DatabaseHandler(this);

        Log.d("INSERT", "Inserting tasks...");

        Log.d("READING", "Reading all tasks....");
        ArrayList<Task> tasks = db.getAllTasks();

        for (Task task : tasks) {
            Log.d("Task :", "Id: " + task.getId() + ", Title: " + task.getTitle() + ", Details: " + task.getDetails());

//        TaskList taskList = new TaskList();
//        ArrayList<Task> fullList = taskList.getList();

        TaskListAdapter taskAdapter = new TaskListAdapter(this, tasks);

        ListView listView = (ListView) findViewById(R.id.tasks_list);
        listView.setAdapter(taskAdapter);
        }
    }


    public void onClick(View listItem) {
        Task task = (Task) listItem.getTag();
        Integer outputId = task.getId();

        Intent intent = new Intent(this, TaskActivity.class);
        intent.putExtra("id", outputId);
        startActivity(intent);
    }

}
