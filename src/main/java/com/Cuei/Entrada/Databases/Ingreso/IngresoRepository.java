/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Cuei.Entrada.Databases.Ingreso;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
/**
 *
 * @author josue
 */

@Repository
public interface IngresoRepository extends JpaRepository<IngresoModel,IngresoKey>{
    /*
    @Query("select u from IngresoModel u where u.id.cita = :#{#citado.cita} and u.id.vehiculo = :#{#citado.vehiculo}")
    @Override
    Optional<IngresoModel> findById(@Param("citado") IngresoKey citado);
    */
    
    @Query("select u from IngresoModel u where u.id.cita >= ?1 and u.entrada = ?2 order by u.id.cita asc")
    List<IngresoModel> findBeforeCita(LocalDateTime fechaReal, int entrada);
    
    @Query("select u from IngresoModel u where u.id.cita < ?1 and u.entrada = ?2 order by u.id.cita asc")
    List<IngresoModel> findAfterCita(LocalDateTime fechaReal, int entrada);
    
    @Query(value = "select c.id from IngresoModel c WHERE c.cita.fechadelete <= ?1")
    public abstract List<IngresoKey> findIdByFechadelete(LocalDateTime fechaReal);

    public abstract void deleteByIdIn(List <IngresoKey> Ids);
    
    List<IngresoModel> findByNombre(String name);



}
