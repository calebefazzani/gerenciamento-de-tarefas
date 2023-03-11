package org.teste.calebe.gerenciamentodetarefascore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.teste.calebe.gerenciamentodetarefascore.dataAcess.TarefaDAO;
import org.teste.calebe.gerenciamentodetarefascore.entidades.Tarefa;
import org.teste.calebe.gerenciamentodetarefascore.service.interfaces.TarefaService;

import java.util.List;

@Component
public class TarefaServiceImpl implements TarefaService {
    private final TarefaDAO dao;

    @Autowired
    public TarefaServiceImpl(TarefaDAO dao) {
        this.dao = dao;
    }

    @Override
    public List<Tarefa> buscaTarefas() {
        return dao.buscaTarefas(null);
    }
}
