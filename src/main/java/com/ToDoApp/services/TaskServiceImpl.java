package com.ToDoApp.services;

import com.ToDoApp.model.Task;
import com.ToDoApp.repository.TaskRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService{

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task getTaskById(int id) {
        Optional<Task> task = taskRepository.findById(id);
        if(task.isPresent()) {
            return task.get();
        }
        return null;
    }

    @Override
    public List<Task> getAllTasks() {
        List<Task> taskList = taskRepository.findAll();
        return taskList;
    }
    @Transactional
    @Override
    public String createTask(String title,int userId) {
        taskRepository.createTask(title,userId);
        return title;
    }

    @Override
    public void deleteTask(int id) {
        taskRepository.deleteById(id);
    }
}
