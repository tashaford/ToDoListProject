package com.example.natashaford.todolist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class menuClass extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId() == R.id.action_home){
            Intent intent = new Intent(this, HomePageActivity.class);
            startActivity(intent);
        }
        if (item.getItemId() == R.id.action_task){
            Intent intent = new Intent(this, FullListActivity.class);
            startActivity(intent);
        }
        if (item.getItemId() == R.id.action_add_task){
            Intent intent = new Intent(this, NewTaskActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

}
