package org.teste.calebe.gerenciamentodetarefasapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.teste.calebe.gerenciamentodetarefascore.service.MyService;

@SpringBootApplication(scanBasePackages = "org.teste.calebe.gerenciamentodetarefascore")
@RestController
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}
	private final MyService service;

	@Autowired
	public ApiApplication(MyService service) {
		this.service = service;
	}

	@GetMapping("/")
	public String home() {
		return service.message();
	}

}
