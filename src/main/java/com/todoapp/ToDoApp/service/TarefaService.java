package com.todoapp.ToDoApp.service;

import com.todoapp.ToDoApp.model.Tarefa;
import org.springframework.stereotype.Service;
import com.todoapp.ToDoApp.repository.TarefaRepository;
import java.util.List;
@Service
public class TarefaService {

    private final TarefaRepository repository;

    public TarefaService(TarefaRepository repository) {
        this.repository = repository;
    }

    public Tarefa adicionarTarefa(Tarefa tarefa) {
        return repository.save(tarefa);
    }

    public List<Tarefa> listaTarefa(){
        return repository.findAll();
    }

    public Tarefa atualizaTarefa(Long id, Tarefa tarefa) {
        Tarefa tarefaAltera = repository.findById(id).get();
        tarefaAltera.setTipo(tarefa.getTipo());
        tarefaAltera.setTexto(tarefa.getTexto());
        return repository.save(tarefaAltera);
    }

    public void deletaTarefa(Long id){
        repository.deleteById(id);
    }

}
