package com.ToDoApp.repository;

import com.ToDoApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "SELECT * FROM user u WHERE u.name = :name AND u.password = :password", nativeQuery = true)
    public User findByNameAndPassword(@Param("name") String name, @Param("password") String password);
}
