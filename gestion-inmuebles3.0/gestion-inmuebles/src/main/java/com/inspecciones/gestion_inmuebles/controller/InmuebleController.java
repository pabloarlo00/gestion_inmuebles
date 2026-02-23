package com.inspecciones.gestion_inmuebles.controller;

import com.inspecciones.gestion_inmuebles.entity.Inmueble;
import com.inspecciones.gestion_inmuebles.service.InmuebleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inmuebles")
public class InmuebleController {
    @Autowired private InmuebleService service;

    @PostMapping("/cliente/{clienteId}")
    public Inmueble crear(@RequestBody Inmueble inmueble, @PathVariable Long clienteId) {
        return service.crearInmueble(inmueble, clienteId);
    }
}