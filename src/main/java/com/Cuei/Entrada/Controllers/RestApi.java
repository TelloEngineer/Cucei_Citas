/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Cuei.Entrada.Controllers;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    /*
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
    public Response saveCita(@RequestBody CitadoModel cita){
        //NOTA: no permitir a ninguna edicion, no tener id.
        System.out.println("es clonado: " + this.citados.isCloned(cita));

        if(!this.vehiculos.isThere(cita.getVehiculo().getPlacas())){
            this.vehiculos.saveVehiculo(cita.getVehiculo());
        }
        cita.setHoradelete(LocalTime.now().with(cita.getHora().plusMinutes(15)));
        if(this.citados.isCloned(cita)){
           return new Response(1, "La cita ya existe, con la misma persona");
        }
        try{
            this.citados.saveCitado(cita);
            return new Response(0, "cita guardada con exito");
        }catch(Exception e){
            return new Response(2, e.getMessage());
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
*/
}

