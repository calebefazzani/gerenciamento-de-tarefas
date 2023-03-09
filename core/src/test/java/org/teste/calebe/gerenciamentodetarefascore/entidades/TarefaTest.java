package org.teste.calebe.gerenciamentodetarefascore.entidades;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.teste.calebe.gerenciamentodetarefascore.contantes.StatusTarefa;

import java.time.LocalDate;

public class TarefaTest {
    private Tarefa tarefa;

    @BeforeEach
    public void init() {
        this.tarefa = new Tarefa("oi", LocalDate.now());
    }

    @Test
    public void tarefaNaoPodeSerIniciadaSemTitulo() {
        try {
            tarefa = new Tarefa(null, LocalDate.now());
            Assertions.fail("Tarefa não pode ser inicializada com título nulo");
        } catch(Exception e) {

        }

        try {
            tarefa = new Tarefa("", LocalDate.now());
            Assertions.fail("Tarefa não pode ser inicializada com título vazio");
        } catch (Exception e) {}
    }

    @Test
    public void tarefaNaoPodeSerIniciadaSemDataDeVencimento() {
        try {
            tarefa = new Tarefa("oi", null);
            Assertions.fail("Tarefa não pode ser inicializada sem data de vencimento");
        } catch(Exception e) {

        }
    }

    @Test
    public void tarefaDeveIniciarComStatusEmAberto() {
        Assertions.assertEquals(StatusTarefa.ABERTO, tarefa.getStatus(), "Devia iniciar com status em aberto");
    }

    @Test
    public void usuarioDevePoderIniciarAtividade() {
        tarefa.iniciaAtividade("usuario", LocalDate.now());
        Assertions.assertEquals(StatusTarefa.EM_ANDAMENTO, tarefa.getStatus(), "Tarefa iniciada deve ter status em andamento");
        Assertions.assertNotNull(tarefa.getDataInicio(), "Tarefa iniciada deve ter uma data de início");
        Assertions.assertNotNull(tarefa.getUsuarioResponsavel(), "Tarefa iniciada deve ter um usuário responsável");
    }

    @Test
    public void usuarioDevePoderConcluirAtividade() {
        tarefa.concluiAtividade(LocalDate.now());
        Assertions.assertEquals(StatusTarefa.CONCLUIDO, tarefa.getStatus(), "Tarefa iniciada deve ter status concluído");
        Assertions.assertNotNull(tarefa.getDataConclusao(), "Tarefa iniciada deve ter uma data de conclusão");

    }
}
