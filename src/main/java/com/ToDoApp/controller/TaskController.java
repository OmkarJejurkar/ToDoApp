package com.ToDoApp.controller;

import com.ToDoApp.model.Task;
import com.ToDoApp.services.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
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
}
