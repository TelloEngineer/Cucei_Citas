/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Cuei.Entrada.Databases.Citado;

import com.Cuei.Entrada.Databases.Ingreso.IngresoModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
@Table(name ="Citado")
@NaturalIdCache
@Cache(
    usage = CacheConcurrencyStrategy.READ_WRITE
)
public @Data @AllArgsConstructor @NoArgsConstructor class CitadoModel {
    @Id @Column(unique = true, nullable = false, name = "identificador_citado")
    private String identificador; //puede ser sus placas, o su nombre
    
    @Column(unique = false, nullable = false, name = "tipo_citado")
    private String tipo; // persona o vehiculo.
    
    @OneToMany(mappedBy = "citado", orphanRemoval = true) // name attribute in ingreso
    @JsonIgnore @ToString.Exclude @Setter(AccessLevel.NONE) // don't create it
    Set<IngresoModel> ingreso = new HashSet<>();;
    
    public void setCitado(Set<IngresoModel> newIngreso){
        this.ingreso.addAll(newIngreso);
    }
}
