package com.example.natashaford.todolist;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;


public class TaskActivity extends menuClass {

    TextView titleToShow;
    TextView detailsToShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        Integer id = extras.getInt("id");

        DatabaseHandler db = new DatabaseHandler(this);

        Log.d("READING", "Reading individual task.");
        Task currentTask = db.getTask(id);

        titleToShow = (TextView) findViewById(R.id.saved_title);
        detailsToShow = (TextView) findViewById(R.id.saved_details);

        titleToShow.setText(currentTask.getTitle());
        detailsToShow.setText(currentTask.getDetails());

    }

    public void onClickDelete(View v){
//        DatabaseHandler db = new DatabaseHandler(this);
//        Task currentTask = db.deleteTask(task.getId());
//
//        Intent intent = new Intent(this, HomePageActivity.class);
//        startActivity(intent);
    }

    public void onClickUpdate(View v){
//        DatabaseHandler db = new DatabaseHandler(this);
//        Task currentTask = db.updateTask(task.getId(), task.getTitle(), task.getDetails());
//
//        Intent intent = new Intent(this, TaskActivity.class);
//        startActivity(intent);
    }


}
