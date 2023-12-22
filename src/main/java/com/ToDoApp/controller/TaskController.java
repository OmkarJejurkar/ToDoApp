package com.ToDoApp.controller;

import com.ToDoApp.model.Task;
import com.ToDoApp.services.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class TaskController {
    @Autowired
    TaskServiceImpl taskServiceImpl;

    @GetMapping("/getTaskById/{id}")
    public ResponseEntity getTaskById(@PathVariable int id) {
        Task task = taskServiceImpl.getTaskById(id);
        if(task!=null)
            return new ResponseEntity(task, HttpStatus.OK);
        else
            return new ResponseEntity("No task found with id = "+id,HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getAllTasks")
    public ResponseEntity getTaskById() {
        List<Task> taskList = taskServiceImpl.getAllTasks();
        return new ResponseEntity(taskList, HttpStatus.OK);
    }

    @PostMapping("/createTask/{userId}")
    public ResponseEntity createTask(@RequestBody Task task, @PathVariable int userId) {
        String savedTaskTitle = taskServiceImpl.createTask(task.getTitle(),userId);
        System.out.println(task);
        return new ResponseEntity(savedTaskTitle, HttpStatus.OK);
    }

    @DeleteMapping("/deleteTask/{id}")
    public ResponseEntity deleteTask(@PathVariable int id) {
        taskServiceImpl.deleteTask(id);
        return new ResponseEntity("task deleted", HttpStatus.OK);
    }
}
