package org.teste.calebe.gerenciamentodetarefascore.dataAcess;

import org.teste.calebe.gerenciamentodetarefascore.entidades.Tarefa;
import org.teste.calebe.gerenciamentodetarefascore.filtros.TarefaFiltro;

import java.util.List;

public interface TarefaDAO {
    List<Tarefa> buscaTarefas(TarefaFiltro filtro);
}
