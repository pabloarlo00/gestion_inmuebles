package com.inspecciones.gestion_inmuebles.repository;

import com.inspecciones.gestion_inmuebles.entity.Desperfecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DesperfectoRepository extends JpaRepository<Desperfecto, Long> { }