package com.example.natashaford.todolist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class NewTaskActivity extends menuClass {

    EditText titleToSave;
    EditText detailsToSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);

        titleToSave = (EditText) findViewById(R.id.editTitle);
        detailsToSave = (EditText) findViewById(R.id.saveDetails);

    }

    public void onClickSave(View v) {
        String titleSave = titleToSave.getText().toString();
        String detailsSave = detailsToSave.getText().toString();

        DatabaseHandler db = new DatabaseHandler(this);
        Task newTask = new Task(titleSave,detailsSave, false);
        db.addTask(newTask);

        Intent intent = new Intent(this, HomePageActivity.class);
        startActivity(intent);

        Toast.makeText(this, R.string.add_new, Toast.LENGTH_LONG).show();
    }
}