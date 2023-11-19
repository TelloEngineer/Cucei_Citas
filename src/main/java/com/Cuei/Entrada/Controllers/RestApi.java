/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Cuei.Entrada.Controllers;


import com.Cuei.Entrada.Databases.Cita.CitaKey;
import com.Cuei.Entrada.Databases.Cita.CitaModel;
import com.Cuei.Entrada.Databases.Cita.CitaService;
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
    CitaService citados; 
    

    @GetMapping()
    public List<CitaModel> getCitas(){
        List<CitaModel> list = this.citados.getcitas();
        System.out.println(list.get(0).getFecha() + " " + list.get(0).getHora());
        return list;
    }

    @GetMapping(path = "/{fecha}/{hora}")
    public Optional<CitaModel> getCitasById(
      CitaKey key  
    ) {
        //System.out.println(cita.getHora().getHour() + "-" + cita.getHora().getMinute() + "-" + cita.getHora().getSecond() + "-"+ cita.getHora().getNano() +"  " + cita.getFecha().getDayOfMonth() + "-" + cita.getFecha().getMonth() + "-" + cita.getFecha().getYear());
        System.out.println(key.getFecha() + " " + key.getHora());
        return this.citados.getById_id(key);
    }

    @PostMapping()
    public Response saveCita(@RequestBody CitaModel cita){
        try{
            cita.setHoradelete(LocalTime.now().with(cita.getHora().plusMinutes(15)));
            this.citados.saveCita(cita);
            return new Response(0, "cita guardada con exito");
        }catch(Exception e){
            return new Response(2, e.getMessage());
        }
    }

    @DeleteMapping( path = "/{fecha}/{hora}")
    public String deleteById(CitaKey id){
        CitaModel citado = this.citados.getcita(id);
        boolean ok = this.citados.deleteCita(id);
        if(ok){
            return "Se elimino la cita con el id: " + id.toString();
        }else{
            return "No se encontro la cita con el id: " + id.toString() + " para elminar";
        }

    }

}

