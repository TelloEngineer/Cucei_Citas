/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Cuei.Entrada.Controllers;


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

import com.Cuei.Entrada.Databases.Cita.CitasModel;
import com.Cuei.Entrada.Databases.Cita.CitasService;
import com.Cuei.Entrada.Databases.Citado.CitadoModel;
import com.Cuei.Entrada.Databases.Citado.CitadoService;
import com.Cuei.Entrada.Databases.Vehiculo.VehiculoModel;
import com.Cuei.Entrada.Databases.Vehiculo.VehiculoService;

/**
 *
 * @author josue
 */
@RestController
@RequestMapping("/CitaCucei")
public class RestApi {
    @Autowired
    CitasService citas; 
    @Autowired
    CitadoService citados; 
    @Autowired
    VehiculoService vehiculos;

    @GetMapping()
    public List<CitasModel> getCitas(){
        return this.citas.getCitasByFecha();
    }

    @GetMapping(path = "/{id}")
    public Optional<CitasModel> getCitasById(@PathVariable("id") Long id) {
        return this.citas.getById(id);
    }

    @PostMapping()
    public CitasModel saveCita(@RequestBody CitasModel cita){
        //NOTA: no permitir a ninguna edicion, no tener id.
        System.out.println("es clonado: " + this.citados.isCloned(cita.getCitado()));

        if(this.citados.isCloned(cita.getCitado())){
           return null;
        }
        this.citados.saveCitado(cita.getCitado());
        if(!this.vehiculos.isThere(cita.getVehiculo().getPlacas())){
            this.vehiculos.saveVehiculo(cita.getVehiculo());
        }
        return this.citas.saveCitas(cita);
    }

    @DeleteMapping( path = "/{id}")
    public String deleteById(@PathVariable("id") Long id){
        boolean ok = this.citas.deleteCitas(id);
        if(ok){
            return "Se elimino el afectado con el id: " + Long.toString(id);
        }else{
            return "No se encontro el afectado con el id: " + Long.toString(id) + " para elminar";
        }

    }
}
