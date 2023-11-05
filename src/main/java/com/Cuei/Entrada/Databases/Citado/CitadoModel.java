/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Cuei.Entrada.Databases.Citado;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NaturalIdCache;

/**
 *
 * @author josue
 */
@Entity
@Table(name ="Citado")
@NaturalIdCache
@Cache(
    usage = CacheConcurrencyStrategy.READ_WRITE
)
public @Data @AllArgsConstructor @NoArgsConstructor class CitadoModel {
    @Id @GeneratedValue @Column(unique = true, nullable = false, name = "idCitas")
    private Long id;
    @Column(unique = false, nullable = false, name = "nombre_persona")
    private String nombre;
    @Column(unique = false, nullable = false, name = "Fecha_cita")
    private String fecha;
    @Column(unique = false, nullable = false, name = "Hora_cita")
    private String hora;
}
