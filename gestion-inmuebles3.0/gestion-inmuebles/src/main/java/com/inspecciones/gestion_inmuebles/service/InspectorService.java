package com.inspecciones.gestion_inmuebles.service;

import com.inspecciones.gestion_inmuebles.entity.Inspector;
import com.inspecciones.gestion_inmuebles.repository.InspectorRepository;
import com.inspecciones.gestion_inmuebles.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InspectorService {
    @Autowired
    private InspectorRepository repository;

    public List<Inspector> listar() {
        return repository.findAll();
    }

    public Inspector guardar(Inspector i) {
        return repository.save(i);
    }

    public Inspector buscar(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Inspector no encontrado"));
    }
    public Inspector actualizar(Long id, Inspector datosNuevos) {
        Inspector existente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inspector no encontrado con id: " + id));

        existente.setNombre(datosNuevos.getNombre());
        existente.setEspecialidad(datosNuevos.getEspecialidad());
        existente.setNumeroColegiado(datosNuevos.getNumeroColegiado());

        return repository.save(existente);
    }
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}