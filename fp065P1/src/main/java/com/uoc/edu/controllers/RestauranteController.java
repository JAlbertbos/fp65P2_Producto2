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
import com.uoc.edu.model.Restaurante;
import com.uoc.edu.repository.RestauranteRepository;


@RestController
@RequestMapping("/restaurante")
public class RestauranteController {
    @Autowired
    private RestauranteRepository restauranteRepository;
    
    @GetMapping("")
    public List<Restaurante> getAllRestaurantes() {
        return restauranteRepository.findAllRestaurantes();
    }
    
    @GetMapping("/{id}")
    public Restaurante getRestauranteById(@PathVariable Long id) {
        return restauranteRepository.findByIdRestaurante(id).orElseThrow(() -> new ResourceNotFoundException("Restaurante no encontrado"));
    }
    
    @PostMapping("")
    public Restaurante createRestaurante(@RequestBody Restaurante restaurante) {
        return restauranteRepository.saveRestaurante(restaurante);
    }
    
    @PutMapping("/{id}")
    public Restaurante updateRestaurante(@PathVariable Long id, @RequestBody Restaurante restauranteActualizado) {
        Restaurante restaurante = restauranteRepository.findByIdRestaurante(id).orElseThrow(() -> new ResourceNotFoundException("Restaurante no encontrado"));
        restaurante.setNombre(restauranteActualizado.getNombre());
        restaurante.setPlato(restauranteActualizado.getPlato());
        restaurante.setPrecio(restauranteActualizado.getPrecio());
        return restauranteRepository.saveRestaurante(restaurante);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRestaurante(@PathVariable Long id) {
        Restaurante restaurante = restauranteRepository.findByIdRestaurante(id).orElseThrow(() -> new ResourceNotFoundException("Restaurante no encontrado"));
        restauranteRepository.deleteRestaurante(restaurante);
        return ResponseEntity.ok().build();
    }
}

