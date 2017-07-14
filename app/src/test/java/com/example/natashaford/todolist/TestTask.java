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
        task = new Task(2, "Create object diagram","Write down notes firstly. Once finished make a professional looking one for notes to submit", false, "work", false);
    }

    @Test
    public void getIdTest() {
        assertEquals(2, task.getId());
    }

    @Test
    public void setIdTest() {
        task.setId(1);
        assertEquals(1, task.getId());
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

    @Test
    public void getCompletedTest() {
        assertEquals(false, task.getCompleted());
    }

    @Test
    public void setCompletedTest() {
        task.setCompleted(true);
        assertEquals(true, task.getCompleted());
    }

    @Test
    public void getCategoryTest() {
        assertEquals("work", task.getCategory());
    }

    @Test
    public void setCCategoryTest() {
        task.setCategory("Home");
        assertEquals("Home", task.getCategory());
    }

    @Test
    public void getPriorityTest() {
        assertEquals(false, task.getPriority());
    }

    @Test
    public void setPriorityTest() {
        task.setPriority(true);
        assertEquals(true, task.getPriority());
    }

}
