package org.teste.calebe.gerenciamentodetarefasdataaccess.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.teste.calebe.gerenciamentodetarefascore.entidades.Tarefa;

@Repository
public interface TarefaRepositorio extends JpaRepository<Tarefa, Long>, JpaSpecificationExecutor<Tarefa> {
}
