package com.todoapp.ToDoApp.Dto;

import com.todoapp.ToDoApp.model.Tarefa;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotBlank;


@Getter
@Setter
public class NovaTarefaDto {

    @NotBlank
    private String tipo;
    @NotBlank
    private String texto;

    public Tarefa converte(){
        Tarefa tarefa = new Tarefa();
        tarefa.setTipo(tipo);
        tarefa.setTexto(texto);
        return tarefa;
    }
}
