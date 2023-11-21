/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Cuei.Entrada.Controllers;


import com.Cuei.Entrada.Databases.Cita.CitaModel;
import com.Cuei.Entrada.Databases.Cita.CitaService;
import com.Cuei.Entrada.Databases.Citado.CitadoKey;
import com.Cuei.Entrada.Databases.Citado.CitadoModel;
import com.Cuei.Entrada.Databases.Citado.CitadoService;
import com.Cuei.Entrada.Databases.Vehiculo.VehiculoModel;
import com.Cuei.Entrada.Databases.Vehiculo.VehiculoService;
import java.time.LocalDateTime;
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

    @GetMapping()
    public List<CitadoModel> getCitados(){
        System.out.println("before: " +this.citados.getBeforeCita(LocalDateTime.now(), 2));
        System.out.println("after: "+this.citados.getAfterCita(LocalDateTime.now(), 2));
        try{
           List<CitadoModel> list = this.citados.getcitados();
           return list; 
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
        
    }

    //GetMethods (just one)_______________________________________________________
    @GetMapping(path = "{fecha}/{placa}") /// necesito editar
    public Optional<CitadoModel> getCitadosById(
      @DateTimeFormat(pattern="dd-MM-yyyy_HH:mm") @PathVariable("fecha") LocalDateTime cita,
      @PathVariable("placa") String placas
    ) { 
        CitadoKey key = new CitadoKey(cita, placas);
        System.err.println(key);
        return this.citados.getById(key);
    }
    //________________________________________________________________________
    
    //Post Methods_____________________________________________________________________________
    
    @PostMapping()
    public Response saveCitado(
        @RequestBody CitadoModel citado
    ){
        try{
            System.out.println(citado.getCita().getFechadelete());
            this.citados.saveCitado(citado);
            return new Response(0, "citado guardada con exito");
        }catch(Exception e){
            return new Response(2, e.getMessage());
        }
       
    }
    
    ///______________________________________________________________________
    //Delete Methods_________________________________________________________
   
    @DeleteMapping(path = "{fecha}/{placa}") /// necesito editar
    public Response deleteCitadoById(
      @DateTimeFormat(pattern="dd-MM-yyyy_HH:mm") @PathVariable("fecha") LocalDateTime cita,
      @PathVariable("placa") String placas
    ) { 
        CitadoKey id = new CitadoKey(cita, placas);
        CitadoModel citado = this.citados.getcitado(id);
        boolean ok = this.citados.deleteCitado(id);
        if(ok){            
            return new Response(0, "Se elimino la cita con el id: " + id.toString());
        }else{
            return new Response(2, "No se encontro la cita con el id: " + id.toString() + " para elminar");
        }
    }
    ///_________________________________________________________________________
}

