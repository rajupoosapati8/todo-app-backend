package com.taskmanager.todoappbackend.modules.task.service;

import com.taskmanager.todoappbackend.modules.task.dto.TaskRequest;
import com.taskmanager.todoappbackend.modules.task.model.Task;
import com.taskmanager.todoappbackend.modules.task.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    // CREATE
    public Task createTask(TaskRequest request) {
        // Initialize with the no-args constructor and use setters
        Task task = new Task();
        task.setTitle(request.title());
        task.setDescription(request.description());
        task.setCompleted(request.completed());
        // createdAt and updatedAt are handled automatically by Mongo Auditing

        return taskRepository.save(task);
    }

    // READ (Get All)
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // READ (Get One by ID)
    public Task getTaskById(String id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Task not found with id: " + id));
    }

    // UPDATE
    public Task updateTask(String id, TaskRequest request) {
        Task existingTask = getTaskById(id);

        existingTask.setTitle(request.title());
        existingTask.setDescription(request.description());
        existingTask.setCompleted(request.completed());

        return taskRepository.save(existingTask);
    }

    // DELETE
    public void deleteTask(String id) {
        if (!taskRepository.existsById(id)) {
            throw new NoSuchElementException("Task not found with id: " + id);
        }
        taskRepository.deleteById(id);
    }

}
