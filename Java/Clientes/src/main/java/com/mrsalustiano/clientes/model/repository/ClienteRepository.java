package com.mrsalustiano.clientes.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mrsalustiano.clientes.model.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	



}
