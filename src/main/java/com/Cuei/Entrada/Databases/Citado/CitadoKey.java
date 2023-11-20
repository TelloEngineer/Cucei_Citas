/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Cuei.Entrada.Databases.Citado;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 *
 * @author josue
 */

public @Data @AllArgsConstructor @NoArgsConstructor class CitadoKey implements Serializable{
    LocalDateTime cita; //debe tener el mismo nombre, que la relacion
    String vehiculo; //debe tener el mismo nombre, que la relacion
}
