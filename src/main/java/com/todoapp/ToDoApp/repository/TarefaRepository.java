package com.todoapp.ToDoApp.repository;

import com.todoapp.ToDoApp.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long>{
}
