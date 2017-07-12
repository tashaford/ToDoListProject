package com.example.natashaford.todolist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class NewTaskActivity extends menuClass {

    EditText titleToSave;
    EditText detailsToSave;
    EditText categoryToSave;
    CheckBox priorityToSave;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);

        titleToSave = (EditText) findViewById(R.id.saveTitle);
        detailsToSave = (EditText) findViewById(R.id.saveDetails);
        categoryToSave = (EditText) findViewById(R.id.saveCategory);
        priorityToSave = (CheckBox) findViewById(R.id.checkBoxPriorityNew);

    }

    public void onClickSave(View v) {
        String titleSave = titleToSave.getText().toString();
        String detailsSave = detailsToSave.getText().toString();
        String categorySave = categoryToSave.getText().toString();
        Boolean prioritySave = priorityToSave.isChecked();


        DatabaseHandler db = new DatabaseHandler(this);
        Task newTask = new Task(titleSave,detailsSave, false, categorySave, prioritySave);
        db.addTask(newTask);

        Intent intent = new Intent(this, FullListActivity.class);
        startActivity(intent);

        Toast.makeText(this, R.string.add_new, Toast.LENGTH_LONG).show();
    }
}