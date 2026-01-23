package com.jaroso.apiejemplo2026.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false, unique = true)
    private String userName;

    private String password;

    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Task> tasks = new ArrayList<>();

    /**
     * Agrega una tarea a la lista de tareas del usuario
     * @param task
     */
    public void addTask(Task task) {
        tasks.add(task);
    }

    /**
     * Elimina una tarea de la lista de tareas del usuario
     * @param task
     */
    public void removeTask(Task task) {
        tasks.remove(task);
    }


}
