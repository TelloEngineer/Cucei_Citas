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
import com.Cuei.Entrada.Databases.Vehiculo.VehiculoService;

/**
 *
 * @author josue
 */
@RestController
@RequestMapping("/CitaCucei")
public class RestApi {
    @Autowired
    CitasService cita; 
    @Autowired
    CitadoService citado; 
    @Autowired
    VehiculoService vehiculo;

    @GetMapping()
    public List<CitasModel> getCitas(){
        return this.cita.getCitasByFecha();
    }

    @GetMapping(path = "/{id}")
    public Optional<CitasModel> getCitasById(@PathVariable("id") Long id) {
        return this.cita.getById(id);
    }

    @PostMapping()
    public CitasModel saveCita(@RequestBody CitasModel cita){
        if(!this.citado.isThere(cita.getCitado().getNombre())){
            this.citado.saveCitas(cita.getCitado());
        }
        if(!this.vehiculo.isThere(cita.getVehiculo().getPlacas())){
            this.vehiculo.saveVehiculo(cita.getVehiculo());
        }
        return this.cita.saveCitas(cita);
    }

    @DeleteMapping( path = "/{id}")
    public String deleteById(@PathVariable("id") Long id){
        boolean ok = this.cita.deleteCitas(id);
        if(ok){
            return "Se elimino el afectado con el id: " + Long.toString(id);
        }else{
            return "No se encontro el afectado con el id: " + Long.toString(id) + " para elminar";
        }

    }
}
