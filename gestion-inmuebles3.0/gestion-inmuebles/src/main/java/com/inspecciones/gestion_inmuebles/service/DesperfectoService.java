package com.inspecciones.gestion_inmuebles.service;

import com.inspecciones.gestion_inmuebles.entity.Desperfecto;
import com.inspecciones.gestion_inmuebles.entity.Inmueble;
import com.inspecciones.gestion_inmuebles.repository.DesperfectoRepository;
import com.inspecciones.gestion_inmuebles.repository.InmuebleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DesperfectoService {
    @Autowired
    private DesperfectoRepository desperfectoRepo;
    @Autowired
    private InmuebleRepository inmuebleRepo;

    public Desperfecto crearParaInmueble(Desperfecto desp, Long inmuebleId) {
        Inmueble inm = inmuebleRepo.findById(inmuebleId).orElseThrow();
        desp.setInmueble(inm);
        return desperfectoRepo.save(desp);
    }

    public Desperfecto actualizar(Long id, Desperfecto detalles) {
        Desperfecto desperfecto = desperfectoRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Desperfecto no encontrado"));

        desperfecto.setDescripcion(detalles.getDescripcion());
        desperfecto.setGravedad(detalles.getGravedad());

        return desperfectoRepo.save(desperfecto);
    }

    public List<Desperfecto> listarTodos() {
        return desperfectoRepo.findAll();
    }
}