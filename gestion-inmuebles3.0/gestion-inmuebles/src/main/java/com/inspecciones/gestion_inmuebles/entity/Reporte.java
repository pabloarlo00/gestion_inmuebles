package com.inspecciones.gestion_inmuebles.entity;

import jakarta.persistence.*;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Reporte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String observacionesGenerales;
    private LocalDate fechaCreacion;

    @OneToOne
    @JoinColumn(name = "inspeccion_id")
    private Inspeccion inspeccion;

    @OneToMany(mappedBy = "reporte", cascade = CascadeType.ALL)
    private List<Desperfecto> desperfectos;
}