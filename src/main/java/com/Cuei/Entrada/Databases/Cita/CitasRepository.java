/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Cuei.Entrada.Databases.Cita;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author josue
 */
@Repository
public interface CitasRepository extends JpaRepository<CitasModel,Long>{
    public abstract List<CitasModel> findByvehiculo_placas (String placas);
    public abstract List<CitasModel> findBycitado_nombre (String nombre);
    public abstract List<CitasModel> findByentrada (int numero_puerta);
    public abstract List<CitasModel> findAllByOrderByCitado_fechaAscCitado_hora();
}