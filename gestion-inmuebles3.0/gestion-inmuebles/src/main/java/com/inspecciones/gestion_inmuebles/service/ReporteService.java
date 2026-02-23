package com.inspecciones.gestion_inmuebles.service;

import com.inspecciones.gestion_inmuebles.entity.*;
import com.inspecciones.gestion_inmuebles.repository.ReporteRepository;
import com.inspecciones.gestion_inmuebles.repository.DesperfectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReporteService {
    @Autowired private ReporteRepository reporteRepo;
    @Autowired private DesperfectoRepository desperfectoRepo;

    public Reporte crearReporte(Reporte reporte) { return reporteRepo.save(reporte); }

    public Desperfecto asignarDesperfectoAReporte(Long reporteId, Long desperfectoId) {
        Reporte rep = reporteRepo.findById(reporteId).orElseThrow();
        Desperfecto desp = desperfectoRepo.findById(desperfectoId).orElseThrow();
        desp.setReporte(rep);
        return desperfectoRepo.save(desp);
    }

    public Reporte actualizarReporte(Long id, Reporte datosNuevos) {
        Reporte reporteExistente = reporteRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Reporte no encontrado con id: " + id));

        reporteExistente.setObservacionesGenerales(datosNuevos.getObservacionesGenerales());
        reporteExistente.setFechaCreacion(datosNuevos.getFechaCreacion());

        if (datosNuevos.getInspeccion() != null) {
            reporteExistente.setInspeccion(datosNuevos.getInspeccion());
        }

        return reporteRepo.save(reporteExistente);
    }

    public Reporte obtenerPorId(Long id) {
        return reporteRepo.findById(id).orElseThrow(() -> new RuntimeException("Reporte no encontrado"));
    }


    public void eliminarReporte(Long id) {
        Reporte reporte = reporteRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("No se puede eliminar: Reporte no encontrado"));

        if (reporte.getDesperfectos() != null) {
            for (Desperfecto d : reporte.getDesperfectos()) {
                d.setReporte(null);
                desperfectoRepo.save(d);
            }
        }

        reporteRepo.delete(reporte);
    }
}