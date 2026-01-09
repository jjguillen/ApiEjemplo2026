package com.jaroso.apiejemplo2026.services;

import com.jaroso.apiejemplo2026.entities.Task;

import java.util.List;

public interface TaskService {

    List<Task> findAll();
    Task findById(Long id);
    void saveTask(String task);
    void deleteTask(Long id);
    void updateTask(Long id, String task);

}
