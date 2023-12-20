package com.ToDoApp.services;

import com.ToDoApp.model.User;

public interface UserService {
    public User getUserByNameAndPassword(String name, String password);
    public User save(User user);
}
