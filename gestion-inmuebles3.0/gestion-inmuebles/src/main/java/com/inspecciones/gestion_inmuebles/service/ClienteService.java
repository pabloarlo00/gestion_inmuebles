package com.inspecciones.gestion_inmuebles.service;

import com.inspecciones.gestion_inmuebles.entity.Cliente;
import com.inspecciones.gestion_inmuebles.repository.ClienteRepository;
import com.inspecciones.gestion_inmuebles.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    public Cliente guardar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado con ID: " + id));
    }

    public Cliente actualizar(Long id, Cliente detalles) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado con id: " + id));

        cliente.setNombre(detalles.getNombre());
        cliente.setDni(detalles.getDni());
        cliente.setEmail(detalles.getEmail());

        return clienteRepository.save(cliente);
    }
    public void eliminar(Long id) {
        Cliente cliente = buscarPorId(id);
        clienteRepository.delete(cliente);
    }
}