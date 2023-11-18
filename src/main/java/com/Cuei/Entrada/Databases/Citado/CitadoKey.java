/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Cuei.Entrada.Databases.Citado;

import com.Cuei.Entrada.Databases.Cita.CitaKey;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;


/**
 *
 * @author josue
 */
@Embeddable
public @Data @AllArgsConstructor @NoArgsConstructor class CitadoKey implements Serializable{
    @Column(unique = false, nullable = false, name = "cita_id")
    CitaKey citaId;
    @Column(unique = false, nullable = false, name = "placas")
    String placas;
}
