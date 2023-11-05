/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Cuei.Entrada.Databases.Citado;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
/**
 *
 * @author josue
 */

@Repository
public interface CitadoRepository extends JpaRepository<CitadoModel,Long>{
    public abstract boolean existsByNombreAndFechaAndHora(String nombre, String fecha, String hora);
    public abstract List<CitadoModel> findByNombreAndFechaAndHora(String nombre, String fecha, String hora);
}
