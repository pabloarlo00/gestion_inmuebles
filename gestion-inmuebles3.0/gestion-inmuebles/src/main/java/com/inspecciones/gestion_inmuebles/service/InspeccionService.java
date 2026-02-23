package com.inspecciones.gestion_inmuebles.service;

import com.inspecciones.gestion_inmuebles.entity.Inspeccion;
import com.inspecciones.gestion_inmuebles.entity.Inspector;
import com.inspecciones.gestion_inmuebles.repository.InspeccionRepository;
import com.inspecciones.gestion_inmuebles.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InspeccionService {
    @Autowired
    private InspeccionRepository inspeccionRepo;

    @Autowired
    private InspectorService inspectorService;

    public Inspeccion crear(Inspeccion inspeccion) {
        return inspeccionRepo.save(inspeccion);
    }

    public Inspeccion asignarInspector(Long inspeccionId, Long inspectorId) {
        Inspeccion ins = inspeccionRepo.findById(inspeccionId)
                .orElseThrow(() -> new ResourceNotFoundException("Inspección no encontrada"));
        Inspector inspector = inspectorService.buscar(inspectorId);
        ins.setInspector(inspector);
        return inspeccionRepo.save(ins);
    }
}