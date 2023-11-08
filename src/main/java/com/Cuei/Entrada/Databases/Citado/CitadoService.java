/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Cuei.Entrada.Databases.Citado;

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
    public List<CitadoModel> getByentradaByCitado(int numero_puerta){
        return this.citado.findByentradaOrderByFechaAscHoraAsc(numero_puerta);
    }
    
    public List<CitadoModel> getCitasByFecha(){
        return  this.citado.findAllByOrderByFechaAscHora();
    }
    
    public CitadoModel saveCitado(CitadoModel citado){
        citado.setHora_to_delete(LocalTime.now().with(citado.getHora().plusMinutes(15)));
        System.out.println(citado.getHora_to_delete().isBefore(LocalTime.now()));
        return this.citado.save(citado);
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
