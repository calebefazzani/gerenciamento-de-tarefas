package org.teste.calebe.gerenciamentodetarefascore.stubs;

import org.teste.calebe.gerenciamentodetarefascore.dataAcess.TarefaDAO;
import org.teste.calebe.gerenciamentodetarefascore.entidades.Tarefa;
import org.teste.calebe.gerenciamentodetarefascore.filtros.TarefaFiltro;

import java.util.ArrayList;
import java.util.List;

public class TarefaDAOTestImpl implements TarefaDAO {

    @Override
    public List<Tarefa> buscaTarefas(TarefaFiltro filtro) {
        return new ArrayList<>();
    }
}



