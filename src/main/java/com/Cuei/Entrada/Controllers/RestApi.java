/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Cuei.Entrada.Controllers;


import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Cuei.Entrada.Databases.Citado.CitadoModel;
import com.Cuei.Entrada.Databases.Citado.CitadoService;
import com.Cuei.Entrada.Databases.Vehiculo.VehiculoService;

/**
 *
 * @author josue
 */
@RestController
@RequestMapping("/CitaCucei")
public class RestApi {
    @Autowired
    CitadoService citados; 
    @Autowired
    VehiculoService vehiculos;

    @GetMapping()
    public List<CitadoModel> getCitas(){
    	citados.deleteCitados(citados.findAfter15Min());
        return this.citados.getCitasByFecha();
    }

    @GetMapping(path = "/{id}")
    public Optional<CitadoModel> getCitasById(@PathVariable("id") Long id) {
    	citados.deleteCitados(citados.findAfter15Min());
        return this.citados.getById(id);
    }

    @PostMapping()
    public String saveCita(@RequestBody CitadoModel cita){
        //NOTA: no permitir a ninguna edicion, no tener id.
        System.out.println("es clonado: " + this.citados.isCloned(cita));

        if(!this.vehiculos.isThere(cita.getVehiculo().getPlacas())){
            this.vehiculos.saveVehiculo(cita.getVehiculo());
        }
        cita.setHoradelete(LocalTime.now().with(cita.getHora().plusMinutes(15)));
        if(this.citados.isCloned(cita)){
           return "1 La cita ya existe, con la misma persona";
        }
        try{
            this.citados.saveCitado(cita);
            return "0 cita guardada con exito";
        }catch(Exception e){
            return "2" + e.getMessage();
        }
    }

    @DeleteMapping( path = "/{id}")
    public String deleteById(@PathVariable("id") Long id){
        CitadoModel citado = this.citados.getcitado(id);
        boolean ok = this.citados.deleteCitado(id);
        if(ok){
            return "Se elimino la cita con el id: " + Long.toString(id);
        }else{
            return "No se encontro la cita con el id: " + Long.toString(id) + " para elminar";
        }

    }
}
