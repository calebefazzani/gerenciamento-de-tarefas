package org.teste.calebe.gerenciamentodetarefasapi.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.teste.calebe.gerenciamentodetarefascore.dataAcess.TarefaDAO;
import org.teste.calebe.gerenciamentodetarefascore.entidades.Tarefa;
import org.teste.calebe.gerenciamentodetarefascore.filtros.TarefaFiltro;
import org.teste.calebe.gerenciamentodetarefascore.service.TarefaServiceImpl;
import org.teste.calebe.gerenciamentodetarefascore.service.interfaces.TarefaService;

import java.util.ArrayList;
import java.util.List;

@TestConfiguration
@ComponentScan(basePackageClasses = {TarefaService.class, TarefaServiceImpl.class})
@EntityScan(basePackageClasses = Tarefa.class)
@EnableAutoConfiguration
public class TestConfig {
    @Bean
    public TarefaDAO getDao() {
        return new TarefaDAO() {
            @Override
            public List<Tarefa> buscaTarefas(TarefaFiltro filtro) {
                return new ArrayList<>();
            }
        };
    }

}