package com.uoc.edu.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uoc.edu.model.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> , PedidoRepositoryCustom{

	
}
