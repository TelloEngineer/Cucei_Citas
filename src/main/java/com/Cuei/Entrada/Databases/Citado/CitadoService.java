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
            return false;
        }   
    }
    
    //Custom_________________________________________________________
    public List<CitadoModel> getBeforeCita(LocalDateTime fechaActual, int entrada){
        return this.citado.findBeforeCita(fechaActual.minusMinutes(1), entrada);
    }
    public List<CitadoModel> getAfterCita(LocalDateTime fechaActual, int entrada){
        return this.citado.findBeforeCita(fechaActual.minusMinutes(1), entrada);
    }
    public void deleteAfter15Min(){
        System.out.println(this.citado.deleteCitaDelete(LocalDateTime.now()));
    }
}
