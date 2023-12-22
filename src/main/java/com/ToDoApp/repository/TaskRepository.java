package com.ToDoApp.repository;

import com.ToDoApp.model.Task;
import com.ToDoApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
    @Modifying
    @Query(value = "insert into task(title,userId) values (:title,:userId)", nativeQuery = true)
    public int createTask(@Param("title") String title, @Param("userId") int userId);

}
