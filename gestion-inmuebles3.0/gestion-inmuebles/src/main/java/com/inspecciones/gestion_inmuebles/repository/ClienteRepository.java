package com.inspecciones.gestion_inmuebles.repository;

import com.inspecciones.gestion_inmuebles.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> { }