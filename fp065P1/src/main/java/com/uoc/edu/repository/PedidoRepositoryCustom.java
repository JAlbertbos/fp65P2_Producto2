package com.uoc.edu.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.uoc.edu.model.Pedido;

@Repository
public interface PedidoRepositoryCustom {

	List<Pedido> findAllPedidos();

	Optional<Pedido> findByIdPedido(Long id);

	Pedido savePedido(Pedido pedido);

	void deletePedido(Pedido pedido);

}
