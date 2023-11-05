/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Cuei.Entrada.Databases.Cita;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author josue
 */
@Service
public class CitasService {
    @Autowired
    CitasRepository citas;
    
    public CitasModel getCita(Long id){
        return this.citas.getReferenceById(id);
    }
    
    public List<CitasModel> getCitasByFecha(){
        return  this.citas.findAllByOrderByCitado_fechaAscCitado_hora();
    }

    public List<CitasModel> getCitas(){
        return  this.citas.findAll();
    }

    public List<CitasModel> getByvehiculo(String placas){
        return this.citas.findByvehiculo_placas(placas);
    }
    public List<CitasModel> getBycitado (String nombre){
        return this.citas.findBycitado_nombre(nombre);
    }
    public List<CitasModel> getByentrada (int numero_puerta){
        return this.citas.findByentrada(numero_puerta);
    }
    public List<CitasModel> getByentradaByCitado(int numero_puerta){
        return this.citas.findByentradaOrderByCitado_fechaAscCitado_horaAsc(numero_puerta);
    }
    public Optional<CitasModel> getById(long id){
        return this.citas.findById(id);
    }

    public CitasModel saveCitas(CitasModel cita){
        return this.citas.save(cita);
    }

    public boolean deleteCitas(long id){
        try{
            this.citas.deleteById(id);
            return true;
        }catch(Exception error){
            return false;
        }   
    }
    
    
}
