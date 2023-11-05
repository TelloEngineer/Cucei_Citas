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
    public CitadoModel getcitado(Long id){
        return this.citado.getReferenceById(id);
    }

    public boolean isThere(Long id){
        return this.citado.existsById(id);
    }
    
    public List<CitadoModel> getcitados(){
        return  this.citado.findAll();
    }
     public Optional<CitadoModel> getById(Long id){
        return this.citado.findById(id);
    }

    public CitadoModel saveCitas(CitadoModel citado){
        return this.citado.save(citado);
    }

    public boolean deleteCitas(Long id){
        try{
            this.citado.deleteById(id);
            return true;
        }catch(Exception error){
            return false;
        }   
    }
}
