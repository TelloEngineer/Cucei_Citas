/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Cuei.Entrada.Controllers;


import com.Cuei.Entrada.Databases.Cita.CitaKey;
import com.Cuei.Entrada.Databases.Cita.CitaModel;
import com.Cuei.Entrada.Databases.Cita.CitaService;
import com.Cuei.Entrada.Databases.Citado.CitadoKey;
import com.Cuei.Entrada.Databases.Citado.CitadoModel;
import com.Cuei.Entrada.Databases.Citado.CitadoService;
import com.Cuei.Entrada.Databases.Vehiculo.VehiculoModel;
import com.Cuei.Entrada.Databases.Vehiculo.VehiculoService;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author josue
 */
@Data @AllArgsConstructor @NoArgsConstructor class Response{
        private int code;
        private String message;
} 
@RestController
@RequestMapping("/CitaCucei")
public class RestApi {

    @Autowired
    CitaService citas; 
    @Autowired
    VehiculoService vehiculos;
    @Autowired
    CitadoService citados;
    
    //GetMethods (all)
    @GetMapping(path = "/cita")
    public List<CitaModel> getCitas(){
        List<CitaModel> list = this.citas.getcitas();
        //System.out.println(list.get(0).getFecha() + " " + list.get(0).getHora());
        return list;
    }

    @GetMapping(path = "/Citado")
    public List<CitadoModel> getCitados(){
        List<CitadoModel> list = this.citados.getcitados();
        //System.out.println(list.get(0).getFecha() + " " + list.get(0).getHora());
        return list;
    }
    
    @GetMapping(path = "/vehiculo")
    public List<VehiculoModel> getVehiculos(){
        List<VehiculoModel> list = this.vehiculos.getVehiculos();
        //System.out.println(list.get(0).getFecha() + " " + list.get(0).getHora());
        return list;
    }
    
    //GetMethods (just one)_______________________________________________________
    @GetMapping(path = "citado/{fecha}/{hora}/{placas}") /// necesito editar
    public Optional<CitadoModel> getCitadosById(
      CitadoKey key
      //@PathVariable("placas") String placas
    ) {
        System.err.println(key);
        return this.citados.getById(key);
    }
    @GetMapping(path = "cita/{fecha}/{hora}")
    public Optional<CitaModel> getCitasById(
      CitaKey key
    ) {
        return this.citas.getById(key.getFecha(), key.getHora());
    }
    @GetMapping(path = "Vehiculo/{placas}")
    public Optional<VehiculoModel> getVehiculosById(
      String key
    ) {
        return this.vehiculos.getById(key);
    }
    //________________________________________________________________________
    
    //Post Methods_____________________________________________________________________________
    
    @PostMapping(path = "/cita")
    public Response saveCita(@RequestBody CitaModel cita){
        try{
            cita.setHoradelete(LocalTime.now().with(cita.getHora().plusMinutes(15)));
            this.citas.saveCita(cita);
            return new Response(0, "cita guardada con exito");
        }catch(Exception e){
            return new Response(2, e.getMessage());
        }
    }
    @PostMapping(path = "/vehiculo")
    public Response saveVehiculo(@RequestBody VehiculoModel vehiculo){
        try{
            this.vehiculos.saveVehiculo(vehiculo);
            return new Response(0, "cita guardada con exito");
        }catch(Exception e){
            return new Response(2, e.getMessage());
        }
    }

    @PostMapping(path = "/Citado")
    public Response saveCitado(@RequestBody CitadoModel citado){
        try{
            this.citados.saveCitado(citado);
            return new Response(0, "cita guardada con exito");
        }catch(Exception e){
            return new Response(2, e.getMessage());
        }
    }
    
    ///______________________________________________________________________
    //Delete Methods_________________________________________________________
    @DeleteMapping( path = "deleteCita/{fecha}/{hora}")
    public Response deleteCitaById(
        CitaKey id
    ){
        CitaModel citado = this.citas.getcita(id);
        boolean ok = this.citas.deleteCita(id);
        if(ok){            
            return new Response(0, "Se elimino la cita con el id: " + id.toString());
        }else{
            return new Response(2, "No se encontro la cita con el id: " + id.toString() + " para elminar");
        }

    }
    @DeleteMapping( path = "deleteVehiculo/{placa}")
    public Response deleteVehiculoById(
        String id
    ){
        VehiculoModel citado = this.vehiculos.getVehiculo(id);
        boolean ok = this.vehiculos.deleteVehiculo(id);
        if(ok){            
            return new Response(0, "Se elimino la cita con el id: " + id);
        }else{
            return new Response(2, "No se encontro la cita con el id: " + id + " para elminar");
        }

    }
  
    ///_________________________________________________________________________

}

