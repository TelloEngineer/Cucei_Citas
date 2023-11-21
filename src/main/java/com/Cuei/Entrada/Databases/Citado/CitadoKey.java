/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Cuei.Entrada.Databases.Citado;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 *
 * @author josue
 */
@Embeddable
public @Data @AllArgsConstructor @NoArgsConstructor class CitadoKey implements Serializable{
    @JsonFormat( shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy HH:mm")
    LocalDateTime cita; //debe tener el mismo nombre, que la relacion
    String vehiculo; //debe tener el mismo nombre, que la relacion
}
