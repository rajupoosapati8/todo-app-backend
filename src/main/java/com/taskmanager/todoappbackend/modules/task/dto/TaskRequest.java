package com.taskmanager.todoappbackend.modules.task.dto;

public record TaskRequest(String title, String description, boolean completed) {
}
