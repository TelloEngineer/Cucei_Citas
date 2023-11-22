/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Cuei.Entrada.Databases.Ingreso;

import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
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
    IngresoRepository ingreso;
    public IngresoModel getcitado(IngresoKey id){
        return this.ingreso.getReferenceById(id);
    }

    public List<IngresoModel> getcitados(){
        return  this.ingreso.findAll();
    }
     public Optional<IngresoModel> getById(IngresoKey id){
        return this.ingreso.findById(id);
    }
    
    public IngresoModel saveCitado(IngresoModel ingreso){
        ///setting automate values.
        //Set fecha to delete
        ingreso.getCita().setFechadelete(ingreso.getCita().getFecha().with(ingreso.getCita().getFecha().toLocalTime().plusMinutes(15)));
        //Set Id
        ingreso.setId(new IngresoKey(ingreso.getCita().getFecha(), ingreso.getCitado().getIdentificador()));
        System.out.println(ingreso.getId());
        
        return this.ingreso.save(ingreso);
    }

    public boolean deleteCitado(IngresoKey id){
        Optional<IngresoModel> entity;
        entity = this.ingreso.findById(id);
        System.out.println(entity);
        if(entity == null){
            return false;
        }
        try{
            this.ingreso.delete(entity.get());
            return true;
        }catch(Exception error){
            System.out.println("______--------"+error.getMessage());
            return false;
        }   
    }
    
    //Custom_________________________________________________________
    public List<IngresoModel> getBeforeCita(LocalDateTime fechaActual, int entrada){
        return this.ingreso.findBeforeCita(fechaActual.minusMinutes(4), entrada);
    }
    public List<IngresoModel> getAfterCita(LocalDateTime fechaActual, int entrada){
        return this.ingreso.findAfterCita(fechaActual.minusMinutes(4), entrada);
    }
    @Transactional
    public boolean deleteCitados(List <IngresoKey> ids){
        if(ids == null){
            return false;
        }
        boolean isEmpty = ids.isEmpty();
        if(!isEmpty){
           this.ingreso.deleteByIdIn(ids); 
        }
        return isEmpty;      
    }
    public List<IngresoKey> findAfter15Min(){
        try{
            return this.ingreso.findIdByFechadelete(LocalDateTime.now());
        }catch(Exception error){
            return null;
        } 
    }

    public List<IngresoModel> getByNombre(String name){
        return this.ingreso.findByNombre(name);
    }
    
}
