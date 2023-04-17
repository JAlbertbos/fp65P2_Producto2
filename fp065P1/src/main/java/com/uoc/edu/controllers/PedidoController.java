package com.uoc.edu.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uoc.edu.controllers.exceptions.ResourceNotFoundException;
import com.uoc.edu.model.Pedido;
import com.uoc.edu.repository.PedidoRepository;


@RestController
@RequestMapping("/pedido")
public class PedidoController {
    @Autowired
    private PedidoRepository pedidoRepository;
    
    @GetMapping("")
    public List<Pedido> getAllPedidos() {
        return pedidoRepository.findAllPedidos();
    }
    
    @GetMapping("/{id}")
    public Pedido getPedidoById(@PathVariable Long id) {
        return pedidoRepository.findByIdPedido(id).orElseThrow(() -> new ResourceNotFoundException("Pedido no encontrado"));
    }
    
    @PostMapping("")
    public Pedido createPedido(@RequestBody Pedido pedido) {
        return pedidoRepository.savePedido(pedido);
    }
    
    @PutMapping("/{id}")
    public Pedido updatePedido(@PathVariable Long id, @RequestBody Pedido pedidoActualizado) {
        Pedido pedido = pedidoRepository.findByIdPedido(id).orElseThrow(() -> new ResourceNotFoundException("Pedido no encontrado"));
        pedido.setFecha(pedidoActualizado.getFecha());
        pedido.setId_cliente(pedidoActualizado.getId_cliente());
        return pedidoRepository.savePedido(pedido);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePedido(@PathVariable Long id) {
        Pedido pedido = pedidoRepository.findByIdPedido(id).orElseThrow(() -> new ResourceNotFoundException("Pedido no encontrado"));
        pedidoRepository.deletePedido(pedido);
        return ResponseEntity.ok().build();
    }
}
