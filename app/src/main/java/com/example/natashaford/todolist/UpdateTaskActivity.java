package com.example.natashaford.todolist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateTaskActivity extends AppCompatActivity {

    Button saveButton;
    EditText titleToSave;
    EditText detailsToSave;
    CheckBox completedToSave;
    EditText categoryToSave;
    CheckBox priorityToSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_task);

        saveButton = (Button)findViewById(R.id.saveButton);
        titleToSave = (EditText) findViewById(R.id.editTitle);
        detailsToSave = (EditText) findViewById(R.id.editDetails);
        completedToSave = (CheckBox) findViewById(R.id.checkBoxUpdate);
        categoryToSave = (EditText) findViewById(R.id.editCategory);
        priorityToSave = (CheckBox) findViewById(R.id.checkBoxPriorityUpdate);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        Integer id = extras.getInt("taskId");

        DatabaseHandler db = new DatabaseHandler(this);

        Task currentTask = db.getTask(id);

        titleToSave.setText(currentTask.getTitle());
        detailsToSave.setText(currentTask.getDetails());
        completedToSave.setChecked(currentTask.getCompleted());
        categoryToSave.setText(currentTask.getCategory());
        priorityToSave.setChecked(currentTask.getPriority());
    }

    public void onClickUpdate(View v) {
        String titleSave = titleToSave.getText().toString();
        String detailsSave = detailsToSave.getText().toString();
        Boolean completedSave = completedToSave.isChecked();
        String categorySave = categoryToSave.getText().toString();
        Boolean prioritySave = priorityToSave.isChecked();

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        Integer id = extras.getInt("taskId");

        DatabaseHandler db = new DatabaseHandler(this);
        db.updateTask(id, titleSave, detailsSave, completedSave, categorySave, prioritySave);

        Intent nextIntent = new Intent(this, FullListActivity.class);
        startActivity(nextIntent);

        Toast.makeText(this, R.string.update_task_message, Toast.LENGTH_LONG).show();
    }
}
