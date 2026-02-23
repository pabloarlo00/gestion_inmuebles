package com.inspecciones.gestion_inmuebles.repository;

import com.inspecciones.gestion_inmuebles.entity.Inspeccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InspeccionRepository extends JpaRepository<Inspeccion, Long> { }