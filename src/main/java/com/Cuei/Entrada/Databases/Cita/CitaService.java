/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Cuei.Entrada.Databases.Cita;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author josue
 */
@Service
public class CitaService {
    @Autowired
    CitaRepository citas;
    
    public CitaModel getcita(CitaKey id){
        return this.citas.getReferenceById(id);
    }

    public List<CitaModel> getcitas(){
        return  this.citas.findAll();
    }
    
    public Optional<CitaModel> getById(CitaKey id){
        return this.citas.findById(id);
    }
    
    public Optional<CitaModel> getById_id(CitaKey id){
        return this.citas.findById(id);
    }
     
    public CitaModel saveCita(CitaModel citado){
        return this.citas.save(citado);
    }

    
    public boolean deleteCita(CitaKey id){
        Optional<CitaModel> entity;
        entity = this.citas.findById(id);
        if(entity == null){
            return false;
        }
        try{
            this.citas.delete(entity.get());
            return true;
        }catch(Exception error){
            return false;
        }   
    }
}
