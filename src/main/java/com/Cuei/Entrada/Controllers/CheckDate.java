/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Cuei.Entrada.Controllers;


import com.Cuei.Entrada.Databases.Citado.CitadoService;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author josue
 */
@Controller
public class CheckDate {
    private int n;
    
    @Autowired
    CitadoService citados;
    
    @GetMapping("/Entrada")
    public String entrada(Model model, @RequestParam int n) {
        this.deleteLateAppointment();
        this.n = n;
        //this.deleteLateAppointment();
        LocalDateTime now = LocalDateTime.now();
        model.addAttribute("citados", citados.getBeforeCita(now,this.n));
        model.addAttribute("tolerancia", citados.getAfterCita(now,this.n));
        return "Entradas";
    }
    
    //@Scheduled(cron = "0 */1 * ? * *")

    private void deleteLateAppointment(){
        this.citados.deleteAfter15Min();
    }

    /*@Scheduled(fixedRate = 500)
    private void reload(){
        String result = restTemplate.getForObject("http://localhost:8080/Entrada?n={hotel}", String.class, this.n);
        System.out.println(result);
    }*/
}
