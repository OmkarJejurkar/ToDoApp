package com.ToDoApp.services;

import com.ToDoApp.model.User;

import java.util.List;

public interface UserService {
    public User getUserByNameAndPassword(String name, String password);
    public User save(User user);
    public List<User> getAllUsers();
}
