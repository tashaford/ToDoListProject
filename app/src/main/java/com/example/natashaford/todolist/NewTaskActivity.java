package com.example.natashaford.todolist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewTaskActivity extends menuClass {

    Button saveButton;
    EditText titleToSave;
    EditText detailsToSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);

        saveButton = (Button)findViewById(R.id.saveButton);
        titleToSave = (EditText) findViewById(R.id.editTitle);
        detailsToSave = (EditText) findViewById(R.id.saveDetails);
    }

    public void onClickSave(View v) {
        String titleSave = titleToSave.getText().toString();
        String detailsSave = detailsToSave.getText().toString();

        DatabaseHandler db = new DatabaseHandler(this);
        Task newTask = new Task(titleSave,detailsSave);
        db.addTask(newTask);

        Intent intent = new Intent(this, HomePageActivity.class);
        startActivity(intent);

        Toast.makeText(this, R.string.add_new, Toast.LENGTH_LONG).show();
    }
}