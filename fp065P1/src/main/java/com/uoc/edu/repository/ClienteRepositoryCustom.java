package com.uoc.edu.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.uoc.edu.model.Cliente;

@Repository
public interface ClienteRepositoryCustom {

	
	List<Cliente> findAllClientes();
	
	Optional<Cliente> findByIdCliente(Long id);
	
	Cliente saveCliente(Cliente cliente);
	
	void deleteCliente(Cliente cliente);
	
	
}
