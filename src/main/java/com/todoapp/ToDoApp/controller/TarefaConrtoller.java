package com.todoapp.ToDoApp.controller;

import com.todoapp.ToDoApp.Dto.NovaTarefaDto;
import com.todoapp.ToDoApp.model.Tarefa;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.todoapp.ToDoApp.service.TarefaService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/tarefa")
public class TarefaConrtoller {
    private TarefaService service;

    public TarefaConrtoller(TarefaService service) {
        this.service = service;
    }

    /*//localhost:8080/tarefa/
    @GetMapping
    public String tarefa(){
        return "Tarefa";
    }*/
    @GetMapping
    public String listaTarefa(Model model){
        List<Tarefa> listaTarefa = service.listaTarefa();
        model.addAttribute("listaTarefa", listaTarefa);
        return ("tarefa");
    }

    //localhost:8080/tarefa/todas
    @GetMapping("/todas")
    public List<Tarefa> listaTarefa(){
        return service.listaTarefa();
    }

    /*//localhost:8080/tarefa/addTarefa
    @PostMapping("/addTarefa")
    public Tarefa adicionarTarefa(@RequestBody NovaTarefaDto tarefaDto){
        return service.adicionarTarefa(tarefaDto.converte());
    }*/

    @GetMapping("/formulario")
    public String formulario(NovaTarefaDto novaTarefaDto){
        return ("tarefa/formulario");
    }

    @PostMapping("/novo")
    public String novaTarefa(@Valid NovaTarefaDto novaTarefaDto, BindingResult result){
        if (result.hasErrors())
            return "tarefa/formulario";
        service.adicionarTarefa(novaTarefaDto.converte());
        return "redirect:/tarefa";
    }

    //localhost:8080/tarefa/<colocar aqui o id da tarefa>
    @PutMapping("/{id}")
    public Tarefa atualizaTarefa(@PathVariable Long id, @RequestBody NovaTarefaDto tarefaDto){
        return service.atualizaTarefa(id, tarefaDto.converte());
    }

    /*//localhost:8080/tarefa/<colocar aqui o id da tarefa>
    @DeleteMapping("/{id}")
    public void deletaTarefa(@PathVariable Long id){
        service.deletaTarefa(id);
    }*/

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public String deletaTarefa(@PathVariable Long id) {
        service.deletaTarefa(id);
        return "redirect:/tarefa";
    }

}
