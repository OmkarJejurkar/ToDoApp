package com.ToDoApp.services;

import com.ToDoApp.model.Task;
import java.util.List;

public interface TaskService {
    public Task getTaskById(int id);
    public List<Task> getAllTasks();
    public String createTask(String title,int userId);
    public void deleteTask(int id);
}
