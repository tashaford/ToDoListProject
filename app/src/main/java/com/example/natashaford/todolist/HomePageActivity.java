package com.example.natashaford.todolist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomePageActivity extends menuClass {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
    }

    public void onClickFullList(View v){
        Intent intent = new Intent(this, FullListActivity.class);
        startActivity(intent);
    }

    public void onClickNew(View v){
        Intent intent = new Intent(this, NewTaskActivity.class);
        startActivity(intent);
    }

}
