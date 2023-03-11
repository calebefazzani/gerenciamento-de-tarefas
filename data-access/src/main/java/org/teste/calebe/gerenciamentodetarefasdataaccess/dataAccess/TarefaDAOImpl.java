package org.teste.calebe.gerenciamentodetarefasdataaccess.dataAccess;

import org.springframework.stereotype.Component;
import org.teste.calebe.gerenciamentodetarefascore.dataAcess.TarefaDAO;
import org.teste.calebe.gerenciamentodetarefascore.entidades.Tarefa;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class TarefaDAOImpl implements TarefaDAO {
    @Override
    public List<Tarefa> buscaTarefas() {
        return new ArrayList<>() {{
            add(new Tarefa("Teste", LocalDate.now()));
        }};
    }
}
