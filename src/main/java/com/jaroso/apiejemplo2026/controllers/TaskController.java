package com.jaroso.apiejemplo2026.controllers;

import com.jaroso.apiejemplo2026.entities.Task;
import com.jaroso.apiejemplo2026.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;


    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> getAllTasks(){
        return ResponseEntity.ok(taskService.findAll());
    }

    public ResponseEntity<Task> getTaskById(Long id){
        Optional<Task> task = taskService.findById(id);
        return task.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }



}
