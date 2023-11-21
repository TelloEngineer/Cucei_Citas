/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Cuei.Entrada.Databases.Citado;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
/**
 *
 * @author josue
 */

@Repository
public interface CitadoRepository extends JpaRepository<CitadoModel,CitadoKey>{
    @Query("select u from CitadoModel u where u.cita.fecha = :#{#citado.cita} and u.vehiculo.placas = :#{#citado.vehiculo}")
    @Override
    Optional<CitadoModel> findById(@Param("citado") CitadoKey citado);
    
    
    @Query("select u from CitadoModel u where u.cita.fecha >= ?1 and u.entrada = ?2 order by u.cita.fecha asc")
    List<CitadoModel> findBeforeCita(LocalDateTime fechaReal, int entrada);
    
    @Query("select u from CitadoModel u where u.cita.fecha < ?1 and u.entrada = ?2 order by u.cita.fecha asc")
    List<CitadoModel> findAfterCita(LocalDateTime fechaReal, int entrada);
    
    @Query("delete from CitadoModel u where u.cita.fechadelete <= ?1")
    List<CitadoModel> deleteCitaDelete(LocalDateTime fechaReal);
}
