/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Cuei.Entrada.Controllers;


import com.Cuei.Entrada.Databases.Cita.CitasService;
import com.Cuei.Entrada.Databases.Citado.CitadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 *
 * @author josue
 */
@Controller
public class Test {
    @Autowired
    CitadoService citas;
    @RequestMapping("/hola")
    public String sayHello(Model model) {
        model.addAttribute("citas", citas.getcitados());
        return "hola";
    }
}
