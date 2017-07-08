package com.example.natashaford.todolist;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by natashaford on 07/07/2017.
 */

public class TestTask {


    Task task;

    @Before
    public void before() {
        task = new Task("Create object diagram","Write down notes firstly. Once finished make a professional looking one for notes to submit");
    }

    @Test
    public void getTitleTest() {
        assertEquals("Create object diagram", task.getTitle());

    }

    @Test
    public void setTitleTest() {
        task.setTitle("Hello");
        assertEquals("Hello", task.getTitle());

    }

    @Test
    public void getDetailsTest() {
        assertEquals("Write down notes firstly. Once finished make a professional looking one for notes to submit", task.getDetails());

    }

    @Test
    public void setDetailsTest() {
        task.setDetails("This is for practise.");
        assertEquals("This is for practise.", task.getDetails());

    }

}
