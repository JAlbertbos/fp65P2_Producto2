package com.uoc.edu.repository;



import java.util.List;
import java.util.Optional;



import org.springframework.stereotype.Repository;

import com.uoc.edu.model.Pedido;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;



@Repository
@Transactional
public class PedidoRepositoryImp implements PedidoRepositoryCustom{


    private final EntityManager entityManager;

    public PedidoRepositoryImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Pedido> findAllPedidos() {
        return entityManager.createQuery("SELECT pe FROM Pedido pe", Pedido.class).getResultList();
    }

    @Override
    public Optional<Pedido> findByIdPedido(Long id) {
        return Optional.ofNullable(entityManager.find(Pedido.class, id));
    }

    @Override
    public Pedido savePedido(Pedido pedido) {
        entityManager.persist(pedido);
        return pedido;
    }

    @Override
    public void deletePedido(Pedido pedido) {
        entityManager.remove(pedido);
    }

}
