package com.example.gerenciamentotarefas.core.model;

import com.example.gerenciamentotarefas.core.model.constants.StatusTarefa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TarefaTest {
    private Tarefa tarefa;

    @Test
    public void deveImpedirGerarUmaTarefaSemDescricao() {
        try {
            String descricao = null;
            tarefa = new Tarefa(descricao);
            Assertions.fail("Deve disparar exceção quando descrição provida for nula");
        } catch(Exception e) {

        }
    }

    @Test
    public void deveGerarDescricaoDefaultQuandoNaoInformada() {
        tarefa = new Tarefa("Teste");
        String descricao = tarefa.getDescricao();
        Assertions.assertNotNull(descricao, "Descrição deve ser preenchida quando não informada");
        Assertions.assertFalse(descricao.isEmpty());
    }

    @Test
    public void deveIniciarTarefaEmAberto() {
        tarefa = new Tarefa("Teste");
        Assertions.assertTrue(tarefa.estaEmAberto(), "Tarefa deve estar em aberto quando criada");
    }

    @Test
    public void deveIniciarComDataVencimentoPadrao() {
        tarefa = new Tarefa("Teste");
        Assertions.assertNotNull(tarefa.getDataVencimento(), "Data de vencimento deve ser preenchida com valor padrão");
    }
}
