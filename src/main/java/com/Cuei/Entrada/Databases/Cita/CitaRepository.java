/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Cuei.Entrada.Databases.Cita;

import com.Cuei.Entrada.Databases.Citado.CitadoModel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author josue
 */
public interface CitaRepository extends JpaRepository<CitaModel,CitaKey>{
    
}
