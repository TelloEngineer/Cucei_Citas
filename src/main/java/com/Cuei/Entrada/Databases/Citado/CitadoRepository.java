/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Cuei.Entrada.Databases.Citado;

import com.Cuei.Entrada.Databases.Cita.CitaKey;
import java.time.LocalDate;
import java.time.LocalTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
/**
 *
 * @author josue
 */

@Repository
public interface CitadoRepository extends JpaRepository<CitadoModel,CitadoKey>{
     @Query(value = "select c from CitadoModel c where c.cita = ?1 and c.vehiculo = ?2")
    public abstract Optional<CitadoModel> findByIdComposed(CitaKey cita, String horadelete);
}
