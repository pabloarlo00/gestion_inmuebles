package com.inspecciones.gestion_inmuebles.controller;

import com.inspecciones.gestion_inmuebles.entity.Desperfecto;
import com.inspecciones.gestion_inmuebles.service.DesperfectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/desperfectos")
public class DesperfectoController {

    @Autowired
    private DesperfectoService desperfectoService;


    @PostMapping("/inmueble/{inmuebleId}")
    public ResponseEntity<Desperfecto> crear(@RequestBody Desperfecto desperfecto, @PathVariable Long inmuebleId) {
        return ResponseEntity.ok(desperfectoService.crearParaInmueble(desperfecto, inmuebleId));
    }


    @PutMapping("/{id}")
    public ResponseEntity<Desperfecto> modificar(@PathVariable Long id, @RequestBody Desperfecto desperfectoDetalles) {

        return ResponseEntity.ok(desperfectoService.actualizar(id, desperfectoDetalles));
    }


    @GetMapping
    public List<Desperfecto> listar() {
        return desperfectoService.listarTodos();
    }
}