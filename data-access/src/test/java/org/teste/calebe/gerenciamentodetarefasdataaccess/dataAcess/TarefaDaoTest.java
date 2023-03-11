package org.teste.calebe.gerenciamentodetarefasdataaccess.dataAcess;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.util.Assert;
import org.teste.calebe.gerenciamentodetarefascore.contantes.StatusTarefa;
import org.teste.calebe.gerenciamentodetarefascore.entidades.Tarefa;
import org.teste.calebe.gerenciamentodetarefascore.filtros.TarefaFiltro;
import org.teste.calebe.gerenciamentodetarefasdataaccess.config.TestConfig;
import org.teste.calebe.gerenciamentodetarefasdataaccess.dataAccess.TarefaDAOImpl;
import org.teste.calebe.gerenciamentodetarefasdataaccess.repositorio.TarefaRepositorio;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

@ContextConfiguration(classes = TestConfig.class)
@DataJpaTest
public class TarefaDaoTest {
    @Autowired
    private TarefaRepositorio repositorio;

    private TarefaDAOImpl dao;

    private Tarefa tarefa1 = new Tarefa("Lavar louça", LocalDate.parse("20200101", DateTimeFormatter.BASIC_ISO_DATE));
    private Tarefa tarefa2 = new Tarefa("Pintar paredes", LocalDate.parse("20200103", DateTimeFormatter.BASIC_ISO_DATE));

    @BeforeEach
    public void init() {
        tarefa1 = repositorio.save(tarefa1);
        tarefa2 = repositorio.save(tarefa2);
        dao = new TarefaDAOImpl(repositorio);
    }

    @AfterEach
    public void clean() {
        repositorio.deleteAll();;
    }

    @Test
    public void deveRetornarComTituloParecido() {
        TarefaFiltro filtro = new TarefaFiltro();
        filtro.setTitulo("Lavar");
        assertFiltro(filtro, tarefa1);
    }

    private void assertFiltro(TarefaFiltro filtro, Tarefa... tarefasEsperadas) {
        List<Tarefa> tarefasEncontradas = dao.buscaTarefas(filtro);
        Assertions.assertTrue(tarefasEncontradas.containsAll(Arrays.asList(tarefasEsperadas)));
        Assertions.assertEquals(tarefasEsperadas.length, tarefasEncontradas.size());
    }

    @Test
    public void deveRetornarComDataMaiorOuIgualASolicitada() {
        TarefaFiltro filtro = new TarefaFiltro();
        filtro.setDataVencimento(LocalDate.parse("20200102", DateTimeFormatter.BASIC_ISO_DATE));
        assertFiltro(filtro, tarefa2);
    }

    @Test
    public void deveRetornarComBaseNoStatus() {
        tarefa1.concluiAtividade(LocalDate.now());
        repositorio.save(tarefa1);

        TarefaFiltro filtro = new TarefaFiltro();
        filtro.setStatus(StatusTarefa.CONCLUIDO);

        assertFiltro(filtro, tarefa1);
    }

    @Test
    public void deveRetornarSemNenhumFiltro() {
        assertFiltro(new TarefaFiltro(), tarefa1, tarefa2);
    }

    @Test
    public void deveRetornarUmaListaVazia() {
        TarefaFiltro filtro = new TarefaFiltro();
        filtro.setTitulo("gaskldgj");
        List<Tarefa> tarefas = dao.buscaTarefas(filtro);
        Assertions.assertTrue(tarefas.isEmpty());
    }
}
