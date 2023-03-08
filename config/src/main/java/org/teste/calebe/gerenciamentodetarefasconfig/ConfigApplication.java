package org.teste.calebe.gerenciamentodetarefasconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {ConfigApplication.CORE_PACKAGE, ConfigApplication.API_PACKAGE, ConfigApplication.DATA_ACCESS_PACKAGE})
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = ConfigApplication.DATA_ACCESS_PACKAGE)
@EntityScan(basePackages = ConfigApplication.CORE_PACKAGE)
public class ConfigApplication {
	public static final String CORE_PACKAGE = "org.teste.calebe.gerenciamentodetarefascore";
	public static final String API_PACKAGE = "org.teste.calebe.gerenciamentodetarefasapi";
	public static final String DATA_ACCESS_PACKAGE = "org.teste.calebe.gerenciamentodetarefasdataaccess";

	public static void main(String[] args) {
		SpringApplication.run(ConfigApplication.class, args);
	}

}
