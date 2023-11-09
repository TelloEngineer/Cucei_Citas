/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Cuei.Entrada.Databases.Citado;

import com.Cuei.Entrada.Databases.Vehiculo.VehiculoModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.time.LocalTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NaturalIdCache;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
    @Id @GeneratedValue @Column(unique = true, nullable = false, name = "idCitado")
    private Long id;
    
    @Column(unique = false, nullable = false, name = "nombre_persona")
    private String nombre;
    
    @Column(unique = false, nullable = false, name = "Fecha_cita")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
    private LocalDate fecha;
    
    @Column(unique = false, nullable = false, name = "Hora_cita")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="HH:mm")
    private LocalTime hora;
    
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "placa_vehiculo") //se crea una columna, donde se guarda el foreign key
    private VehiculoModel vehiculo; //relacion many(citas) to one (vehiculo) 
    
    @Column(unique = false, nullable = false, name = "puerta_entrada")
    private int entrada;
    
    @JsonIgnore
    @Column(unique = false, nullable = false, name = "Hora_delete")
    private LocalTime horadelete;
    

}