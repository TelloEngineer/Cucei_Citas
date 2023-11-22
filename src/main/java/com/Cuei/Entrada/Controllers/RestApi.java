/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Cuei.Entrada.Controllers;


import com.Cuei.Entrada.Databases.Ingreso.IngresoKey;
import com.Cuei.Entrada.Databases.Ingreso.IngresoModel;
import com.Cuei.Entrada.Databases.Ingreso.IngresoService;

import java.time.LocalDateTime;
import java.util.List;
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
    IngresoService ingresos;
    
    //GetMethods (all)
    
    @GetMapping()
    public List<IngresoModel> getIngresos(){
        System.out.println("before: " +this.ingresos.getBeforeCita(LocalDateTime.now(), 2));
        System.out.println("after: "+this.ingresos.getAfterCita(LocalDateTime.now(), 2));
        try{
           List<IngresoModel> list = this.ingresos.getIngresos();
           return list; 
        }catch(Exception e){
            System.out.println(e);
            return null;
        }       
    }
    
    //GetMethods (just one)_______________________________________________________
    /*
    @GetMapping(path = "{fecha}/{placa}") /// necesito editar
    public Optional<CitadoModel> getCitadosById(
      @DateTimeFormat(pattern="dd-MM-yyyy_HH:mm") @PathVariable("fecha") LocalDateTime cita,
      @PathVariable("placa") String placas
    ) { 
        CitadoKey key = new CitadoKey(cita, placas);
        System.err.println(key);
        return this.ingresos.getById(key);
    }
    */
    @GetMapping(path = "{identificador}") /// necesito editar  
    public List<IngresoModel> getIngresosByCitado(
      @PathVariable("identificador") String identificador
    ) { 
        this.ingresos.deleteIngresos(this.ingresos.findAfter15Min());
        System.err.println(identificador);
        return this.ingresos.getByIdentificador(identificador);
    }
    //________________________________________________________________________
    
    //Post Methods_____________________________________________________________________________
    
    @PostMapping()
    public Response saveIngreso(
        @RequestBody IngresoModel ingreso
    ){
        try{
            System.out.println(ingreso.getCita().getFechadelete());
            this.ingresos.saveIngreso(ingreso);
            return new Response(0, "cita guardada con exito");
        }catch(Exception e){
            return new Response(2, e.getMessage());
        }
       
    }
    
    ///______________________________________________________________________
    //Delete Methods_________________________________________________________
   
    @DeleteMapping(path = "{fecha}/{identificador}") 
    public Response deleteIngresoById(
      @DateTimeFormat(pattern="dd-MM-yyyy_HH:mm") @PathVariable("fecha") LocalDateTime cita,
      @PathVariable("identificador") String identificadores
    ) { 
        IngresoKey id = new IngresoKey(cita, identificadores);
        boolean ok = this.ingresos.deleteIngreso(id);
        if(ok){            
            return new Response(0, "Se elimino la cita del: " + id.getCita() + '\n' +" con las identificadores: " + id.getCitado());
        }else{
            return new Response(2, "No se encontro la cita del: " + id.getCita() +  "con las identificadores: " + id.getCitado() + " para elminar");
        }
    }
    ///_________________________________________________________________________
}

