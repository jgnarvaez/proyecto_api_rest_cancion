package co.edu.unicauca.distribuidos.core.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.distribuidos.core.services.ICancionService;
import co.edu.unicauca.distribuidos.core.services.DTO.CancionDTO;

@RestController
@RequestMapping("/api")
public class CancionRestController {
    @Autowired
    private ICancionService cancionService;

    @GetMapping("/canciones")
    public List<CancionDTO> index() {
        return cancionService.findAll();
    }

    @GetMapping("/canciones/{codigo}")
    public CancionDTO show(@PathVariable Integer codigo) {
        CancionDTO objCancion = null;
        objCancion = cancionService.findById(codigo);
        return objCancion;
    }

    @PostMapping("/canciones")
    public CancionDTO create(@RequestBody CancionDTO cancion) {
        CancionDTO objCancion = null;
        objCancion = cancionService.save(cancion);
        return objCancion;
    }

    @PutMapping("/canciones/{codigo}")
    public CancionDTO update(@RequestBody CancionDTO cancion, @PathVariable Integer codigo) {
        CancionDTO objCancion = null;
        CancionDTO cancionActual = cancionService.findById(codigo);
        if (cancionActual != null) {
            objCancion = cancionService.update(codigo, cancion);
        }
        return objCancion;
    }

    @DeleteMapping("/canciones/{codigo}")
    public Boolean delete(@PathVariable Integer codigo) {
        Boolean bandera = false;
        CancionDTO cancionActual = cancionService.findById(codigo);
        if (cancionActual != null) {
            bandera = cancionService.delete(codigo);
        }
        return bandera;
    }
}