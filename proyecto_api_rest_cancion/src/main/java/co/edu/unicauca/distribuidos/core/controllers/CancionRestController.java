package co.edu.unicauca.distribuidos.core.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import co.edu.unicauca.distribuidos.core.services.ICancionService;
import co.edu.unicauca.distribuidos.core.services.DTO.CancionDTO;

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

    @GetMapping("canciones2/{name}/{age}")
    public String getMessage(@PathVariable String name,
            @PathVariable("age") String edad) {
        String msg = String.format("%s es %s años viejo", name, edad);
        System.out.println(msg);
        return msg;
    }

    @GetMapping("consultarClientes")
    public String getMessageParametros(@RequestParam String nombres,
            @RequestParam String apellidos,
            @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fecha) {
        String msg = String.format("buscando un cliente por nombre: %s, apellidos: %s fecha %s", nombres, apellidos,
                fecha);
        System.out.println(msg);
        return msg;
    }

    @PostMapping("/clientes")
    public CancionDTO create(@RequestBody CancionDTO cliente) {
        CancionDTO objCliente = null;
        objCliente = cancionService.save(cliente);
        return objCliente;
    }

    @PutMapping("/clientes/{id}")
    public CancionDTO update(@RequestBody CancionDTO cliente, @PathVariable Integer id) {
        CancionDTO objCliente = null;
        CancionDTO clienteActual = cancionService.findById(id);
        if (clienteActual != null) {
            objCliente = cancionService.update(id, cliente);
        }
        return objCliente;
    }

    @DeleteMapping("/clientes/{id}")
    public Boolean delete(@PathVariable Integer id) {
        Boolean bandera = false;
        CancionDTO clienteActual = cancionService.findById(id);
        if (clienteActual != null) {
            bandera = cancionService.delete(id);
        }
        return bandera;

    }

    @GetMapping("/clientes/listarCabeceras")
    public void listarCabeceras(@RequestHeader Map<String, String> headers) {
        System.out.println("cabeceras");
        headers.forEach((key, value) -> {
            System.out.println(String.format("Cabecera '%s' = %s", key, value));
        });
    }
}
