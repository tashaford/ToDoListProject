package com.example.natashaford.todolist;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class PriorityListActivity extends menuClass {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_priority_list);

        DatabaseHandler db = new DatabaseHandler(this);

        ArrayList<Task> tasks = db.getPriorityTasks();

        for (Task task : tasks) {

                Log.d("Task :", "Id: " + task.getId() + ", Title: " + task.getTitle() + ", Details: " + task.getDetails() + ", Checked: " + task.getCompleted() + ", Category " + task.getCategory() + ", Priority" + task.getPriority());

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
