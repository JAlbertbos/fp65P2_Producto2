package com.uoc.edu.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.uoc.edu.model.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ClienteRepositoryImpl implements ClienteRepositoryCustom {

    
    private final EntityManager entityManager;
    
    public ClienteRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Cliente> findAllClientes() {
        return entityManager.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
    }

    @Override
    public Optional<Cliente> findByIdCliente(Long id) {
        return Optional.ofNullable(entityManager.find(Cliente.class, id));
    }

    @Override
    public Cliente saveCliente(Cliente cliente) {
        if (cliente.getId_cliente() == null) {
            entityManager.persist(cliente);
            return cliente;
        } else {
            return entityManager.merge(cliente);
        }
    }

    @Override
    public void deleteCliente(Cliente cliente) {
        entityManager.remove(cliente);
    }
}
