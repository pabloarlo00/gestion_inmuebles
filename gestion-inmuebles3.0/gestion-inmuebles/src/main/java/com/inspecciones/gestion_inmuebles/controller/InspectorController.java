package com.inspecciones.gestion_inmuebles.controller;

import com.inspecciones.gestion_inmuebles.entity.Inspector;
import com.inspecciones.gestion_inmuebles.service.InspectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/inspectores")
public class InspectorController {

    @Autowired
    private InspectorService inspectorService;

    @GetMapping
    public List<Inspector> listar() {
        return inspectorService.listar();
    }

    @PostMapping
    public Inspector crear(@RequestBody Inspector inspector) {
        return inspectorService.guardar(inspector);
    }

    @PutMapping("/{id}")
    public Inspector actualizar(@PathVariable Long id, @RequestBody Inspector inspectorActualizado) {
        return inspectorService.actualizar(id, inspectorActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        inspectorService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}