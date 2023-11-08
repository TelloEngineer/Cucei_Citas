/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Cuei.Entrada.Controllers;


import com.Cuei.Entrada.Databases.Citado.CitadoService;
import com.Cuei.Entrada.Databases.Vehiculo.VehiculoService;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author josue
 */
@Controller
public class CheckDate {
    @Autowired
    CitadoService citados;
    @Autowired
    VehiculoService vehiculos;
    
    @GetMapping("/Entrada")
    public String entrada(Model model, @RequestParam int n) {
        this.deleteLateAppointment(); // delete after 15 minutes
        model.addAttribute("citados", citados.getByentradaByCitado(n));
        return "Entradas";
    }
    
    private void deleteLateAppointment(){
        System.out.println(citados.findAfter15Min());
    }
}
