package com.mrsalustiano.clientes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClientesApplication {

/*	@Bean
	public CommandLineRunner run(@Autowired ClienteRepository repository) {
		return args -> {
			Cliente cliente =  new Cliente("Marcelo", "12345678901");
			repository.save(cliente);
		};
	}*/
	
	
	public static void main(String[] args) {
		SpringApplication.run(ClientesApplication.class, args);
	}

}
