package com.uoc.edu.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.uoc.edu.controllers.exceptions.ResourceNotFoundException;
import com.uoc.edu.model.Cliente;
import com.uoc.edu.repository.ClienteRepository;


@Controller
public class ClienteController {
    @Autowired
    private ClienteRepository clienteRepository;
    
    @GetMapping("/cliente")
    public String main() {
        return "cliente";
    }
    
    
    @GetMapping("")
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAllClientes();
    }
    
    @GetMapping("/{id}")
    public Cliente getClienteById(@PathVariable Long id) {
        return clienteRepository.findByIdCliente(id).orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado"));
    }
    
    @PostMapping("")
    public Cliente createCliente(@RequestBody Cliente cliente) {
        return clienteRepository.saveCliente(cliente);
    }
    
    @PutMapping("/{id}")
    public Cliente updateCliente(@PathVariable Long id, @RequestBody Cliente clienteActualizado) {
        Cliente cliente = clienteRepository.findByIdCliente(id).orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado"));
        cliente.setNombre(clienteActualizado.getNombre());
        cliente.setDireccion(clienteActualizado.getDireccion());
        return clienteRepository.saveCliente(cliente);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCliente(@PathVariable Long id) {
        Cliente cliente = clienteRepository.findByIdCliente(id).orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado"));
        clienteRepository.deleteCliente(cliente);
        return ResponseEntity.ok().build();
    }
}
