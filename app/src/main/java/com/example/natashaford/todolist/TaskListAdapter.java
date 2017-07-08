package com.example.natashaford.todolist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by natashaford on 07/07/2017.
 */

public class TaskListAdapter extends ArrayAdapter<Task> {

    public TaskListAdapter(Context context, ArrayList<Task> tasks){
        super(context, 0, tasks);
    }

    @Override
    public View  getView(int position, View listItemView, ViewGroup parent){

        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.activity_full_list, parent, false);
        }
        Task currentTask = getItem(position);

        TextView title = (TextView) listItemView.findViewById(R.id.task_title);
        title.setText(currentTask.getTitle().toString());

        listItemView.setTag(currentTask);

        return listItemView;
    }
}
