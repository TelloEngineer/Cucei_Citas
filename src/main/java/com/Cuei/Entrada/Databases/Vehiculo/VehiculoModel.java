/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Cuei.Entrada.Databases.Vehiculo;

import com.Cuei.Entrada.Databases.Citado.CitadoModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NaturalIdCache;

/**
 *
 * @author josue
 */
@Entity
@Table(name ="Vehiculo")
@NaturalIdCache
@Cache(
    usage = CacheConcurrencyStrategy.READ_WRITE
)
public @Data @AllArgsConstructor @NoArgsConstructor class VehiculoModel {
    @Id @Column(unique = true, nullable = false, name = "placas_vehiculo")
    private String placas;
    @Column(unique = false, nullable = false, name = "marca_vehiculo")
    private String marca;
    @Column(unique = false, nullable = false, name = "color_vehiculo")
    private String color;
    @Column(unique = false, nullable = false, name = "tipo_vehiculo")
    private String tipo;
    
    @OneToMany(mappedBy = "vehiculo", orphanRemoval = true) // name attribute in citado
    @JsonIgnore
    @ToString.Exclude Set<CitadoModel> citado;
}
