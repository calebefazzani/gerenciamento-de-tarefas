package org.teste.calebe.gerenciamentodetarefascore.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.teste.calebe.gerenciamentodetarefascore.config.TestConfig;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest("service.message=Hello")
@ContextConfiguration(classes = TestConfig.class)
public class MyServiceTest {

    @Autowired
    private MyService myService;

    @Test
    public void contextLoads() {
        assertThat(myService.message()).isNotNull();
    }

}
