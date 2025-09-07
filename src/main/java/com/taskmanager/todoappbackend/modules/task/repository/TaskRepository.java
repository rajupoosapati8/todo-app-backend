package com.taskmanager.todoappbackend.modules.task.repository;

import com.taskmanager.todoappbackend.modules.task.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends MongoRepository<Task, String> {
}
