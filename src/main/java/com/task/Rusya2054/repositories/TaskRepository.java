package com.task.Rusya2054.repositories;

import com.task.Rusya2054.models.Task ;
import com.task.Rusya2054.models.User;
import com.task.Rusya2054.models.enums.Priority;
import com.task.Rusya2054.models.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface TaskRepository extends JpaRepository<Task, Long> {
    Task findByPriority(Priority priority);
    Task findByStatus(Status status);
    List<Task> findByExecutor(User executor);
}
