/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Cuei.Entrada.Databases.Cita;

import com.Cuei.Entrada.Databases.Ingreso.IngresoModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NaturalIdCache;

/**
 *
 * @author josue
 */
@Entity
@Table(name ="Cita")
@NaturalIdCache
@Cache(
    usage = CacheConcurrencyStrategy.READ_WRITE
)
public @Data @AllArgsConstructor @NoArgsConstructor  class CitaModel {
    @Id
    @Column(unique = false, nullable = false, name = "Fecha_cita")
    @JsonFormat( shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy HH:mm")
    private LocalDateTime fecha;

    @Column(unique = false, nullable = false, name = "fecha_delete")
    private LocalDateTime fechadelete;
    
    @OneToMany(mappedBy = "cita", orphanRemoval = true) // name attribute in Ingreso
    @JsonIgnore @ToString.Exclude @Setter(AccessLevel.NONE) // don't create it
    Set<IngresoModel> ingreso = new HashSet<>();;

    public void setCitado(Set<IngresoModel> newIngreso) {
        this.ingreso.addAll(newIngreso);
    }
}



