package com.mrsalustiano.clientes.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.mrsalustiano.clientes.model.entity.Cliente;
import com.mrsalustiano.clientes.model.repository.ClienteRepository;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

	@Autowired ClienteRepository repository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente Salvar(@RequestBody Cliente cliente) {
		return repository.save(cliente);
		
	}
	
	
	@GetMapping("{id}")
	public Cliente searchById(@PathVariable Integer id) {
		return repository.findById(id).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	
	
}
