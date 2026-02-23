package com.inspecciones.gestion_inmuebles.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class Inspeccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime fecha;
    private String estado;

    @ManyToOne
    @JoinColumn(name = "inmueble_id")
    private Inmueble inmueble;

    @ManyToOne
    @JoinColumn(name = "inspector_id")
    private Inspector inspector;

    @OneToOne(mappedBy = "inspeccion", cascade = CascadeType.ALL)
    @JsonIgnore
    private Reporte reporte;
}