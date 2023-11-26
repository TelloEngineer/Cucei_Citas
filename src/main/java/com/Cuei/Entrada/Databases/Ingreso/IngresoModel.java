/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Cuei.Entrada.Databases.Ingreso;

import com.Cuei.Entrada.Databases.Cita.CitaModel;
import com.Cuei.Entrada.Databases.Citado.CitadoModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table(name ="ingreso")
@NaturalIdCache
@Cache(
    usage = CacheConcurrencyStrategy.READ_WRITE
)
public @Data @AllArgsConstructor @NoArgsConstructor class IngresoModel {
    
    @EmbeddedId
    private IngresoKey id;

    @Column(unique = false, nullable = false, name = "puerta_ingreso")
    private int entrada;

    
    @ManyToOne(fetch = FetchType.LAZY, cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.REMOVE})
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    //@OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "citado_identificador") //se crea una columna, donde se guarda el foreign key
    private CitadoModel citado; //relacion many(citas) to one (vehiculo) 
    
    
    @ManyToOne(fetch = FetchType.LAZY, cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.REMOVE})
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    //@OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name="cita_fecha", referencedColumnName="Fecha_cita")
    private CitaModel cita; //relacion many(citas) to one (vehiculo) 
}