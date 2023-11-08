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
/**
 *
 * @author josue
 */

@Repository
public interface CitadoRepository extends JpaRepository<CitadoModel,Long>{
    public abstract boolean existsByNombreAndFechaAndHora(String nombre, LocalDate fecha, LocalTime hora);
    public abstract List<CitadoModel> findByNombreAndFechaAndHora(String nombre, LocalDate fecha, LocalTime hora);
    public abstract List<CitadoModel> findByvehiculo_placas (String placas);
    public abstract List<CitadoModel> findByentrada (int numero_puerta);
    public abstract List<CitadoModel> findBynombre (String nombre);
    public abstract List<CitadoModel> findByentradaOrderByFechaAscHoraAsc(int entrada);
    public abstract List<CitadoModel> findAllByOrderByFechaAscHora();
    
}
