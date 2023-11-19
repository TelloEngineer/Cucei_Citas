/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Cuei.Entrada.Databases.Cita;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author josue
 */
public interface CitaRepository extends JpaRepository<CitaModel,CitaKey>{
    @Query(value = "select c from CitaModel c where c.fecha = :#{#key.fecha} and c.hora = :#{#key.hora}")
    @Override
    public abstract Optional<CitaModel> findById(@Param("key") CitaKey id);

}
