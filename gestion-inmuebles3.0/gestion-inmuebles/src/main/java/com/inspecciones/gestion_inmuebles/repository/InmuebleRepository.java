package com.inspecciones.gestion_inmuebles.repository;

import com.inspecciones.gestion_inmuebles.entity.Inmueble;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InmuebleRepository extends JpaRepository<Inmueble, Long> { }