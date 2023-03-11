package org.teste.calebe.gerenciamentodetarefascore.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.teste.calebe.gerenciamentodetarefascore.dataAcess.TarefaDAO;
import org.teste.calebe.gerenciamentodetarefascore.entidades.Tarefa;
import org.teste.calebe.gerenciamentodetarefascore.service.MyService;
import org.teste.calebe.gerenciamentodetarefascore.service.ServiceProperties;
import org.teste.calebe.gerenciamentodetarefascore.service.TarefaServiceImpl;
import org.teste.calebe.gerenciamentodetarefascore.service.interfaces.TarefaService;
import org.teste.calebe.gerenciamentodetarefascore.stubs.TarefaDAOTestImpl;

@TestConfiguration
@ComponentScan(basePackageClasses = {TarefaService.class, TarefaServiceImpl.class})
@EntityScan(basePackageClasses = Tarefa.class)
@EnableAutoConfiguration
public class TestConfig {

    @Bean
    public TarefaDAO getDao() {
        return new TarefaDAOTestImpl();
    }

    @Bean
    public MyService getServiceProperties() {
        return new MyService(new ServicePropertiesTest());
    }


}


class ServicePropertiesTest extends ServiceProperties {
    @Override
    public String getMessage() {
        return "oi";
    }
}



