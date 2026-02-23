package com.inspecciones.gestion_inmuebles.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "inspectors")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Inspector {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    private String especialidad;

    @Column(name = "numero_colegiado", unique = true)
    private String numeroColegiado;
}