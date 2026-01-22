package com.jaroso.apiejemplo2026.repositories;

import com.jaroso.apiejemplo2026.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {
    Optional<Task> findByTitle(String title); //Select * from Task where title = <title>
    List<Task> findAllByOrderByTitleAsc(); //Select * from Task order by title
    List<Task> findAllByOrderByTitleDesc();
    List<Task> findAllByDescriptionContainingIgnoreCase(String description);
    List<Task> findAllByFinishDateAfter(java.time.LocalDate date);

    @Query("Select t from tasks t where t.title LIKE %:texto%")
    List<Task> buscarPorTitulo(@Param("texto") String texto);

}
