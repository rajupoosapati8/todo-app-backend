package com.taskmanager.todoappbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class TodoAppBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodoAppBackendApplication.class, args);
    }

}
