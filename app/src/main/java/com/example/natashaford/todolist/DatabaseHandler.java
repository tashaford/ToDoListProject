package com.example.natashaford.todolist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 9;

    private static final String DATABASE_NAME = "tasksDB";

    private static final String TABLE_TASKS = "tasks";

    private static final String KEY_ID = "id";
    private static final String KEY_TITLE = "title";
    private static final String KEY_DETAILS = "details";
    private static final String KEY_COMPLETED = "completed";
    private static final String KEY_CATEGORY = "category";
    private static final String KEY_PRIORITY = "priority";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABLE_TASKS +
                "(" + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_TITLE + " TEXT, "
                + KEY_DETAILS + " TEXT, "
                + KEY_COMPLETED + " INTEGER, "
                + KEY_CATEGORY + " TEXT,"
                + KEY_PRIORITY + " INTEGER)";
        db.execSQL(sql);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TASKS);
        onCreate(db);
    }

    public void addTask(Task task) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_TITLE, task.getTitle());
        values.put(KEY_DETAILS, task.getDetails());
        values.put(KEY_COMPLETED, task.getCompleted() ? 1 : 0);
        values.put(KEY_CATEGORY, task.getCategory());
        values.put(KEY_PRIORITY, task.getPriority() ? 1 : 0);
        db.insert(TABLE_TASKS, null, values);
        db.close();
    }

    public Task getTask(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Task task = null;

        Cursor cursor = db.query(TABLE_TASKS, new String[]
                {KEY_ID, KEY_TITLE, KEY_DETAILS, KEY_COMPLETED, KEY_CATEGORY, KEY_PRIORITY},
                KEY_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
            task = new Task(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2), cursor.getInt(3)>0, cursor.getString(4), cursor.getInt(5)>0);
        }
        return task;
    }

    public ArrayList<Task> getAllTasks() {
        ArrayList<Task> taskList = new ArrayList<Task>();

        String sql = "SELECT * FROM " + TABLE_TASKS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        Task task = null;
        if (cursor.moveToFirst()) {
            do {
                task = new Task();
                task.setId(Integer.parseInt(cursor.getString(0)));
                task.setTitle(cursor.getString(1));
                task.setDetails(cursor.getString(2));
                task.setCompleted(cursor.getInt(3)>0);
                task.setCategory(cursor.getString(4));
                task.setPriority(cursor.getInt(5)>0);
                taskList.add(task);
            } while (cursor.moveToNext());
        }
        return taskList;
    }

    public ArrayList<Task> getPriorityTasks(){
        ArrayList<Task> priorityList = new ArrayList<Task>();

        String sql = "SELECT * FROM " + TABLE_TASKS + " WHERE " + KEY_PRIORITY + " = 1";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        Task task = null;
        if (cursor.moveToFirst()){
            do {
                task = new Task();
                task.setId(Integer.parseInt(cursor.getString(0)));
                task.setTitle(cursor.getString(1));
                task.setDetails(cursor.getString(2));
                task.setCompleted(cursor.getInt(3)>0);
                task.setCategory(cursor.getString(4));
                task.setPriority(cursor.getInt(5)>0);
                priorityList.add(task);
            } while (cursor.moveToNext());
        } return priorityList;
    }

    public Integer deleteTask(Integer id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_TASKS, KEY_ID + " = ? ", new String[] {Integer.toString(id)});
    }

    public void deleteAll(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_TASKS);
    }

    public boolean updateTask(Integer id, String title, String details, boolean completed, String category, boolean priority){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_ID, id);
        contentValues.put(KEY_TITLE, title);
        contentValues.put(KEY_DETAILS, details);
        contentValues.put(KEY_COMPLETED, completed);
        contentValues.put(KEY_CATEGORY, category);
        contentValues.put(KEY_PRIORITY, priority);
        db.update(TABLE_TASKS, contentValues, KEY_ID + " = ? ", new String[] {Integer.toString(id)});
        return true;
    }
}