package com.inspecciones.gestion_inmuebles.repository;

import com.inspecciones.gestion_inmuebles.entity.Inspector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InspectorRepository extends JpaRepository<Inspector, Long> { }