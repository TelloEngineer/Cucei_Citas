/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Cuei.Entrada.Controllers;


import java.time.LocalDateTime;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.Cuei.Entrada.Databases.Ingreso.IngresoService;

/**
 *
 * @author josue
 */
@Controller
public class CheckDate {
    private int n;
    
    @Autowired
    IngresoService ingresos;
    
    @GetMapping("/Entrada")
    public String entrada(Model model, @RequestParam int n) {
        this.deleteLateAppointment();
        this.n = n;
        //this.deleteLateAppointment();
        LocalDateTime now = LocalDateTime.now().atZone(ZoneId.systemDefault())
                .withZoneSameInstant(ZoneId.of("America/Mexico_City")).toLocalDateTime();
        model.addAttribute("ingresos", ingresos.getBeforeCita(now,this.n));
        model.addAttribute("tolerancia", ingresos.getAfterCita(now,this.n));
        return "Entradas";
    }
    
    //@Scheduled(cron = "0 */1 * ? * *")

    private void deleteLateAppointment(){
        System.out.println("after 15 min: " + this.ingresos.findAfter15Min());
        this.ingresos.deleteIngresos(this.ingresos.findAfter15Min());
    }

    /*@Scheduled(fixedRate = 500)
    private void reload(){
        String result = restTemplate.getForObject("http://localhost:8080/Entrada?n={hotel}", String.class, this.n);
        System.out.println(result);
    }*/
}
