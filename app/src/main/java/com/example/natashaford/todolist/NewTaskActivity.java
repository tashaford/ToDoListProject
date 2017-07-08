package com.example.natashaford.todolist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class NewTaskActivity extends menuClass {

    Button saveButton;
    TextView titleToSave;
    TextView detailsToSave;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);

        saveButton = (Button)findViewById(R.id.saveButton);
        titleToSave = (EditText)findViewById(R.id.saveTitle);
        detailsToSave = (EditText)findViewById(R.id.saveDetails);


    }

    public void onClickSave(View v) {
        SavedTextPreferences.setStoredTitle(this, titleToSave.getText().toString());
        SavedTextPreferences.setStoredDetails(this, detailsToSave.getText().toString());
        Intent intent = new Intent(this, HomePageActivity.class);
        startActivity(intent);

        Toast.makeText(this, R.string.add_new, Toast.LENGTH_LONG).show();
    }
}