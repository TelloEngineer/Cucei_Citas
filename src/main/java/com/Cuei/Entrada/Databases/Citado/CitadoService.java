/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Cuei.Entrada.Databases.Citado;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author josue
 */
@Service
public class CitadoService {
    @Autowired
    CitadoRepository citados;
    
    public CitadoModel getCitado(String identificador){
        return this.citados.getReferenceById(identificador);
    }
    
    public List<CitadoModel> getCitados(){
        return  this.citados.findAll();
    }
     public Optional<CitadoModel> getById(String identificador){
        return this.citados.findById(identificador);
    }

    public CitadoModel saveCitado(CitadoModel citados){
        return this.citados.save(citados);
    }

    public boolean isThere(String identificador){
        return this.citados.existsById(identificador);
    }

    public boolean deleteVehiculo(String identificador){
        Optional<CitadoModel> entity;
        entity = this.citados.findById(identificador);
        System.out.println(entity);
        if(entity == null){
            return false;
        }
        try{
            this.citados.delete(entity.get());
            return true;
        }catch(Exception error){
            return false;
        }   
    }
}
