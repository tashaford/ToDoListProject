package com.example.natashaford.todolist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

public class TaskListAdapter extends ArrayAdapter<Task> {

    public TaskListAdapter(Context context, ArrayList<Task> tasks){
        super(context, 0, tasks);
    }

    @Override
    public View getView(int position, View listItemView, ViewGroup parent){

        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.tasks_list, parent, false);
        }
        Task currentTask = getItem(position);

        TextView title = (TextView) listItemView.findViewById(R.id.task_title);
        title.setText(currentTask.getTitle());

        TextView category = (TextView) listItemView.findViewById(R.id.category);
        category.setText(currentTask.getCategory());

        CheckBox cbCompleted = (CheckBox) listItemView.findViewById(R.id.checkBox);
        cbCompleted.setChecked(currentTask.getCompleted());

        CheckBox cbPriority = (CheckBox) listItemView.findViewById(R.id.checkBoxPriorityList);
        cbPriority.setChecked(currentTask.getPriority());

        listItemView.setTag(currentTask);

        return listItemView;
    }
}
