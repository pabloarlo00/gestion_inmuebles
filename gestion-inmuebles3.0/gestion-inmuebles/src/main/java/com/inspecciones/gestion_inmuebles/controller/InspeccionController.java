package com.inspecciones.gestion_inmuebles.controller;

import com.inspecciones.gestion_inmuebles.entity.Inspeccion;
import com.inspecciones.gestion_inmuebles.service.InspeccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inspecciones")
public class InspeccionController {
    @Autowired private InspeccionService service;

    @PostMapping
    public Inspeccion crear(@RequestBody Inspeccion ins) { return service.crear(ins); }

    @PutMapping("/{id}/asignar-inspector/{inspectorId}")
    public Inspeccion asignar(@PathVariable Long id, @PathVariable Long inspectorId) {
        return service.asignarInspector(id, inspectorId);
    }
}