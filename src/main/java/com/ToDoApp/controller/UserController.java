package com.ToDoApp.controller;

import com.ToDoApp.model.User;
import com.ToDoApp.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserServiceImpl userServiceImpl;

    @PostMapping("/authenticateUser")
    public ResponseEntity authenticateUser(@RequestBody User user) {
        if(userServiceImpl.getUserByNameAndPassword(user.getName(), user.getPassword())!=null) {
            return new ResponseEntity("User Authenticated", HttpStatus.OK);
        }
        else {
            return new ResponseEntity("Unauthorised user", HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/createUser")
    public ResponseEntity createUser(@RequestBody User user) {
        userServiceImpl.save(user);
        return new ResponseEntity<>(user,HttpStatus.CREATED);
    }

}
