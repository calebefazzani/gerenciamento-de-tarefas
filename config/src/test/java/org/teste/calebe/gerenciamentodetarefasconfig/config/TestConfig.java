package org.teste.calebe.gerenciamentodetarefasconfig.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.teste.calebe.gerenciamentodetarefasconfig.ConfigApplication;
import org.teste.calebe.gerenciamentodetarefascore.entidades.Tarefa;
import org.teste.calebe.gerenciamentodetarefascore.service.TarefaServiceImpl;
import org.teste.calebe.gerenciamentodetarefascore.service.interfaces.TarefaService;

@TestConfiguration
@ComponentScan(basePackages = {ConfigApplication.CORE_PACKAGE, ConfigApplication.API_PACKAGE, ConfigApplication.DATA_ACCESS_PACKAGE})
@EnableAutoConfiguration
@EntityScan(basePackages = ConfigApplication.CORE_PACKAGE)
public class TestConfig {
}
