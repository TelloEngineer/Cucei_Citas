/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Cuei.Entrada.Databases.Cita;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author josue
 */
@Embeddable
public @Data @AllArgsConstructor @NoArgsConstructor class CitaKey implements Serializable {    
    @DateTimeFormat(pattern="dd-MM-yyyy")
    private LocalDate fecha;
    @DateTimeFormat(pattern="HH:mm") 
    private LocalTime hora;
}
