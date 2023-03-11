package org.teste.calebe.gerenciamentodetarefasconfig;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.teste.calebe.gerenciamentodetarefasconfig.config.TestConfig;

@SpringBootTest
@ContextConfiguration(classes = TestConfig.class)
class ConfigApplicationTests {

	@Test
	void contextLoads() {
	}

}
