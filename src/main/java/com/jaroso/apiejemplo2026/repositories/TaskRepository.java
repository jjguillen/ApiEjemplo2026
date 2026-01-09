package com.jaroso.apiejemplo2026.repositories;

import com.jaroso.apiejemplo2026.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
