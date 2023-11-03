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
    CitadoRepository citado;
    public CitadoModel getcitado(String nombre_citado){
        return this.citado.getReferenceById(nombre_citado);
    }
    
    public List<CitadoModel> getcitados(){
        return  this.citado.findAll();
    }
     public Optional<CitadoModel> getById(String nombre_citado){
        return this.citado.findById(nombre_citado);
    }

    public CitadoModel saveCitas(CitadoModel citado){
        return this.citado.save(citado);
    }

    public boolean deleteCitas(String nombre_citado){
        try{
            this.citado.deleteById(nombre_citado);
            return true;
        }catch(Exception error){
            return false;
        }   
    }
}
