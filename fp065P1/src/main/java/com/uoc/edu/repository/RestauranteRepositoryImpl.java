package com.uoc.edu.repository;


import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Repository;

import com.uoc.edu.model.Restaurante;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;


@Repository
@Transactional
public class RestauranteRepositoryImpl implements RestauranteRepositoryCustom {

    
    private EntityManager entityManager;

    @Override
    public List<Restaurante> findAllRestaurantes() {
        return entityManager.createQuery("SELECT p FROM Producto p", Restaurante.class).getResultList();
        
    }

    @Override
    public Optional<Restaurante> findByIdRestaurante(Long id) {
        return Optional.ofNullable(entityManager.find(Restaurante.class, id));
    }

    @Override
    public Restaurante saveRestaurante(Restaurante restaurante) {
    	entityManager.persist(restaurante);
        return restaurante;
    }

    @Override
    public void deleteRestaurante(Restaurante restaurante) {
    	entityManager.remove(restaurante);
    }

}

