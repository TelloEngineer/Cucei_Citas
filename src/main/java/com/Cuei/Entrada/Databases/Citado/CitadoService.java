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
/*
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
    
    public boolean isCloned(CitadoModel citado){
        return this.citado.existsByNombreAndFechaAndHora(citado.getNombre(), citado.getFecha(), citado.getHora());
    }
    
    public List<CitadoModel> getcitados(){
        return  this.citado.findAll();
    }
     public Optional<CitadoModel> getById(Long id){
        return this.citado.findById(id);
    }

    public List<CitadoModel> getByvehiculo(String placas){
        return this.citado.findByvehiculo_placas(placas);
    }
    
    public List<CitadoModel> getBycitado(String nombre){
        return this.citado.findBynombre(nombre);
    }
    public List<CitadoModel> getByentrada (int numero_puerta){
        return this.citado.findByentrada(numero_puerta);
    }
    public List<CitadoModel> getCitaBeforeCita(LocalDate fecha, LocalTime hora,int numero_puerta){
        return this.citado.findByentradaBeforeCita(fecha,hora.minusMinutes(1),numero_puerta);
    }
    
    public List<CitadoModel> getCitaAfterCita(LocalDate fecha, LocalTime hora,int numero_puerta){
        return this.citado.findByentradaAfterCita(fecha,hora.minusMinutes(1),numero_puerta);
    }

    public List<CitadoModel> getCitasByFecha(){
        return  this.citado.findAllByOrderByFechaAscHora();
    }
    
    public List<Long> findAfter15Min(){
        LocalDateTime dateTime = LocalDateTime.now();
        try{
            return this.citado.findIdByFechaAndHoradeleteBefore(dateTime.toLocalDate(), dateTime.toLocalTime());
        }catch(Exception error){
            return null;
        } 
    }
    
    public CitadoModel saveCitado(CitadoModel citado){
        citado.setHoradelete(LocalTime.now().with(citado.getHora().plusMinutes(15)));
        System.out.println(citado.getHoradelete() + " - " +LocalTime.now());
        return this.citado.save(citado);
    }

    @Transactional
    public boolean deleteCitados(List <Long> ids){
        if(ids == null){
            return false;
        }
        boolean isEmpty = ids.isEmpty();
        if(!isEmpty){
           this.citado.deleteByIdIn(ids); 
        }
        return isEmpty;      
    }
    
    public boolean deleteCitado(Long id){
        try{
            this.citado.deleteById(id);
            return true;
        }catch(Exception error){
            return false;
        }   
    }
}
*/