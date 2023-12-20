package com.ToDoApp.services;

import com.ToDoApp.model.User;
import com.ToDoApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    public User getUserByNameAndPassword(String name, String password) {
            User user =  userRepository.findByNameAndPassword(name, password);
            if(user!=null) {
                return user;
            }
            return null;
    }

    @Override
    public User save(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
