package com.uoc.edu.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.uoc.edu.model.Restaurante;


@Repository
public interface RestauranteRepositoryCustom {

	List<Restaurante> findAllRestaurantes();

	Optional<Restaurante> findByIdRestaurante(Long id);

	Restaurante saveRestaurante(Restaurante producto);

	void deleteRestaurante(Restaurante producto);
	
}
