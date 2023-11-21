/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Cuei.Entrada.Databases.Citado;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author josue
 */

@Repository
public interface CitadoRepository extends JpaRepository<CitadoModel,CitadoKey>{
    /*
    @Query("select u from CitadoModel u where u.id.cita = :#{#citado.cita} and u.id.vehiculo = :#{#citado.vehiculo}")
    @Override
    Optional<CitadoModel> findById(@Param("citado") CitadoKey citado);
    */
    
    @Query("select u from CitadoModel u where u.id.cita >= ?1 and u.entrada = ?2 order by u.id.cita asc")
    List<CitadoModel> findBeforeCita(LocalDateTime fechaReal, int entrada);
    
    @Query("select u from CitadoModel u where u.id.cita < ?1 and u.entrada = ?2 order by u.id.cita asc")
    List<CitadoModel> findAfterCita(LocalDateTime fechaReal, int entrada);
    
   

}
