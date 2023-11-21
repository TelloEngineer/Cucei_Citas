/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Cuei.Entrada.Databases.Citado;

import jakarta.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
public class CitadoService {
    @Autowired
    CitadoRepository citado;
    public CitadoModel getcitado(CitadoKey id){
        return this.citado.getReferenceById(id);
    }

    public List<CitadoModel> getcitados(){
        return  this.citado.findAll();
    }
     public Optional<CitadoModel> getById(CitadoKey id){
        return this.citado.findById(id);
    }
    
    public CitadoModel saveCitado(CitadoModel citado){
        ///setting automate values.
        //Set fecha to delete
        citado.getCita().setFechadelete(citado.getCita().getFecha().with(citado.getCita().getFecha().toLocalTime().plusMinutes(15)));
        //Set Id
        citado.setId(new CitadoKey(citado.getCita().getFecha(), citado.getVehiculo().getPlacas()));
        System.out.println(citado.getId());
        
        return this.citado.save(citado);
    }

    public boolean deleteCitado(CitadoKey id){
        Optional<CitadoModel> entity;
        entity = this.citado.findById(id);
        System.out.println(entity);
        if(entity == null){
            return false;
        }
        try{
            this.citado.delete(entity.get());
            return true;
        }catch(Exception error){
            System.out.println("______--------"+error.getMessage());
            return false;
        }   
    }
    
    //Custom_________________________________________________________
    public List<CitadoModel> getBeforeCita(LocalDateTime fechaActual, int entrada){
        return this.citado.findBeforeCita(fechaActual.minusMinutes(1), entrada);
    }
    public List<CitadoModel> getAfterCita(LocalDateTime fechaActual, int entrada){
        return this.citado.findAfterCita(fechaActual.minusMinutes(1), entrada);
    }
    @Transactional
    public boolean deleteCitados(List <CitadoKey> ids){
        if(ids == null){
            return false;
        }
        boolean isEmpty = ids.isEmpty();
        if(!isEmpty){
           this.citado.deleteByIdIn(ids); 
        }
        return isEmpty;      
    }
    public List<CitadoKey> findAfter15Min(){
        try{
            return this.citado.findIdByFechadelete(LocalDateTime.now());
        }catch(Exception error){
            return null;
        } 
    }

    public List<CitadoModel> getByNombre(String name){
        return this.citado.findByNombre(name);
    }
}
