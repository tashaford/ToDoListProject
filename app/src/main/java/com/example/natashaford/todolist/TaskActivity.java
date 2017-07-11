package com.example.natashaford.todolist;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


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
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        Integer id = extras.getInt("id");
        DatabaseHandler db = new DatabaseHandler(this);
        db.deleteTask(id);

        Intent endIntent = new Intent(this, FullListActivity.class);
        startActivity(endIntent);
        Toast.makeText(this, R.string.delete_task_message, Toast.LENGTH_LONG).show();
    }

    public void onClickUpdate(View v){
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        Integer id = extras.getInt("id");

        Intent newIntent = new Intent(this, UpdateTaskActivity.class);
        newIntent.putExtra("taskId", id);
        startActivity(newIntent);
    }

}
