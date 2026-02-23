package com.inspecciones.gestion_inmuebles.controller;

import com.inspecciones.gestion_inmuebles.entity.Reporte;
import com.inspecciones.gestion_inmuebles.entity.Desperfecto;
import com.inspecciones.gestion_inmuebles.service.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reportes")
public class ReporteController {

    @Autowired
    private ReporteService reporteService;

    @PostMapping
    public Reporte crear(@RequestBody Reporte reporte) {
        return reporteService.crearReporte(reporte);
    }

    @PutMapping("/{reporteId}/desperfecto/{desperfectoId}")
    public Desperfecto asignarDesperfecto(@PathVariable Long reporteId, @PathVariable Long desperfectoId) {
        return reporteService.asignarDesperfectoAReporte(reporteId, desperfectoId);
    }

    @GetMapping("/{id}")
    public Reporte obtenerPorId(@PathVariable Long id) {
        return reporteService.obtenerPorId(id);
    }

    @PutMapping("/{id}")
    public Reporte actualizar(@PathVariable Long id, @RequestBody Reporte reporte) {
        return reporteService.actualizarReporte(id, reporte);
    }
    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id) {
        reporteService.eliminarReporte(id);
        return "Reporte eliminado correctamente con id: " + id;
    }
}