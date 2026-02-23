package com.inspecciones.gestion_inmuebles.service;

import com.inspecciones.gestion_inmuebles.entity.Inmueble;
import com.inspecciones.gestion_inmuebles.entity.Cliente;
import com.inspecciones.gestion_inmuebles.repository.InmuebleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InmuebleService {
    @Autowired
    private InmuebleRepository inmuebleRepository;
    @Autowired
    private ClienteService clienteService;

    public Inmueble crearInmueble(Inmueble inmueble, Long clienteId) {
        Cliente cliente = clienteService.buscarPorId(clienteId);
        inmueble.setCliente(cliente);
        return inmuebleRepository.save(inmueble);
    }
}