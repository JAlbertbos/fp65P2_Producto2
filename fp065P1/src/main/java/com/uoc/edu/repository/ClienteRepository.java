package com.uoc.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uoc.edu.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> , ClienteRepositoryCustom{

	
}
