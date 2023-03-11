package org.teste.calebe.gerenciamentodetarefasdataaccess;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.teste.calebe.gerenciamentodetarefasdataaccess.config.TestConfig;

@SpringBootTest
@ContextConfiguration(classes = TestConfig.class)
class DataAccessApplicationTests {

	@Test
	void contextLoads() {
	}

}
