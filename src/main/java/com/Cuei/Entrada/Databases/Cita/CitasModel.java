/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Cuei.Entrada.Databases.Cita;

import com.Cuei.Entrada.Databases.Citado.CitadoModel;
import com.Cuei.Entrada.Databases.Vehiculo.VehiculoModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
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
@Table(name ="Citas")
@NaturalIdCache
@Cache(
    usage = CacheConcurrencyStrategy.READ_WRITE
)
public @Data @AllArgsConstructor @NoArgsConstructor class CitasModel {
    @Id @GeneratedValue @Column(unique = true, nullable = false, name = "idCitas")
    private Long id;
    
    @OneToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "nombre_citado") //se crea una columna, donde se guarda el foreign key
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private CitadoModel citado; //relacion many(citas) to one (citado)
   
    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @JoinColumn(name = "placa_vehiculo") //se crea una columna, donde se guarda el foreign key
    private VehiculoModel vehiculo; //relacion many(citas) to one (vehiculo) 
    
    @Column(unique = false, nullable = false, name = "puerta_entrada")
    private int entrada;
}

