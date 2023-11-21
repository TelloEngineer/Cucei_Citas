/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Cuei.Entrada.Databases.Citado;

import com.Cuei.Entrada.Databases.Cita.CitaModel;
import com.Cuei.Entrada.Databases.Vehiculo.VehiculoModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.CascadeType;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    
    @EmbeddedId
    private CitadoKey id;
    
    @Column(unique = false, nullable = false, name = "nombre_persona")
    private String nombre;

    @Column(unique = false, nullable = false, name = "puerta_entrada")
    private int entrada;

    
    @ManyToOne(fetch = FetchType.LAZY, cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.REMOVE})
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    //@OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "placa_vehiculo") //se crea una columna, donde se guarda el foreign key
    private VehiculoModel vehiculo; //relacion many(citas) to one (vehiculo) 
    
    
    @ManyToOne(fetch = FetchType.LAZY, cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.REMOVE})
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    //@OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name="cita_fecha", referencedColumnName="Fecha_cita")
    private CitaModel cita; //relacion many(citas) to one (vehiculo) 
}