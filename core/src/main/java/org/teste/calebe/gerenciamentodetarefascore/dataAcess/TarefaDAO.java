package org.teste.calebe.gerenciamentodetarefascore.dataAcess;

import org.teste.calebe.gerenciamentodetarefascore.entidades.Tarefa;

import java.util.List;

public interface TarefaDAO {
    List<Tarefa> buscaTarefas();
}
