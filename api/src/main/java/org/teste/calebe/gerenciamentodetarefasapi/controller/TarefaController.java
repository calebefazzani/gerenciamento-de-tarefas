package org.teste.calebe.gerenciamentodetarefasapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.teste.calebe.gerenciamentodetarefascore.entidades.Tarefa;
import org.teste.calebe.gerenciamentodetarefascore.service.interfaces.TarefaService;

import java.util.List;

@RequestMapping("/tarefa")
@RestController
public class TarefaController {
    private final TarefaService service;

    @Autowired
    public TarefaController(TarefaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Tarefa> getTarefas() {
        return service.buscaTarefas();
    }
}
