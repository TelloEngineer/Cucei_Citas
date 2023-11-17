/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Cuei.Entrada.Databases.Citado;

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
public interface CitadoRepository extends JpaRepository<CitadoModel,Long>{
    public abstract boolean existsByNombreAndFechaAndHora(String nombre, LocalDate fecha, LocalTime hora);
    public abstract List<CitadoModel> findByvehiculo_placas (String placas);
    
    public abstract List<CitadoModel> findByentrada (int numero_puerta);
    public abstract List<CitadoModel> findBynombre (String nombre);
    
    public abstract List<CitadoModel> findByentradaOrderByFechaAscHoraAsc(int entrada);
    public abstract List<CitadoModel> findAllByOrderByFechaAscHora();
    
    @Query(value = "select c from CitadoModel c WHERE c.fecha >= ?1 and c.hora >= ?2 and c.entrada = ?3 order by c.fecha asc, c.hora asc")
    public abstract List<CitadoModel> findByentradaBeforeCita(LocalDate fecha, LocalTime horadelete, int entrada);
    @Query(value = "select c from CitadoModel c WHERE c.fecha >= ?1 and c.hora < ?2 and c.entrada = ?3 order by c.fecha asc, c.hora asc")
    public abstract List<CitadoModel> findByentradaAfterCita(LocalDate fecha, LocalTime horadelete, int entrada);
    
    @Query(value = "select c.id from CitadoModel c WHERE (c.fecha <= ?1 and c.horadelete <= ?2) or (c.fecha < ?1)")
    public abstract List<Long> findIdByFechaAndHoradeleteBefore(LocalDate fecha, LocalTime horadelete);
    public abstract List<CitadoModel> findByFecha(LocalDate fecha);
    
    public abstract void deleteByIdIn(List <Long> Ids);
}
