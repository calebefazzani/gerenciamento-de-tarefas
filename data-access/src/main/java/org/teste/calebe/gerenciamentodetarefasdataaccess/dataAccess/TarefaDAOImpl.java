package org.teste.calebe.gerenciamentodetarefasdataaccess.dataAccess;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.teste.calebe.gerenciamentodetarefascore.dataAcess.TarefaDAO;
import org.teste.calebe.gerenciamentodetarefascore.entidades.Tarefa;
import org.teste.calebe.gerenciamentodetarefascore.filtros.TarefaFiltro;
import org.teste.calebe.gerenciamentodetarefasdataaccess.repositorio.TarefaRepositorio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class TarefaDAOImpl implements TarefaDAO {
    private final TarefaRepositorio repositorio;
    @Autowired
    public TarefaDAOImpl(TarefaRepositorio repositorio) {
        this.repositorio = repositorio;
    }
    @Override
    public List<Tarefa> buscaTarefas(TarefaFiltro filtro) {

        return repositorio.findAll(Specification
                .where(filtro.getTituloSpec())
                .and(filtro.getDataVencimentoSpec())
                .and(filtro.getStatusSpec())
        );
    }
}
