package org.teste.calebe.gerenciamentodetarefasdataaccess.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.teste.calebe.gerenciamentodetarefasdataaccess.repositorio.TarefaRepositorio;

@TestConfiguration
@ComponentScan(basePackages = {TestConfig.CORE_PACKAGE, TestConfig.DATA_ACCESS_PACKAGE})
@EntityScan(basePackages = TestConfig.CORE_PACKAGE)
@EnableAutoConfiguration
@EnableJpaRepositories(basePackageClasses = TarefaRepositorio.class)
public class TestConfig {
    public static final String CORE_PACKAGE = "org.teste.calebe.gerenciamentodetarefascore";
    public static final String DATA_ACCESS_PACKAGE = "org.teste.calebe.gerenciamentodetarefasdataaccess";
}
