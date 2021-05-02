package com.mrsalustiano.clientes.rest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.mrsalustiano.clientes.model.entity.Cliente;
import com.mrsalustiano.clientes.model.entity.ServicoPrestado;
import com.mrsalustiano.clientes.model.repository.ClienteRepository;
import com.mrsalustiano.clientes.model.repository.ServicoPrestadoRepository;
import com.mrsalustiano.clientes.rest.dto.ServicoPrestadoDTO;
import com.mrsalustiano.clientes.util.BigDecimalConverter;

@RestController
@RequestMapping("/api/servicos-prestados")
public class ServicoPrestadoController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ServicoPrestadoRepository repository;
	
	@Autowired
	private BigDecimalConverter bigDecimalConverter;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ServicoPrestado salvar(@RequestBody ServicoPrestadoDTO dto) {
		
		LocalDate data = LocalDate.parse(dto.getData(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		Integer idCliente = dto.getIdCliente();
		
		Cliente cliente  = clienteRepository.findById(idCliente)
				.orElseThrow( () -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cliente Inexistente"));
		
		
		ServicoPrestado  servicoPrestado = new ServicoPrestado();
		
		
		servicoPrestado.setDescricao(dto.getDescricao());
		servicoPrestado.setData(data);
		servicoPrestado.setCliente(cliente);
		servicoPrestado.setValor(bigDecimalConverter.converter(dto.getPreco()));
		
		return repository.save(servicoPrestado);
		
		
	}

}
