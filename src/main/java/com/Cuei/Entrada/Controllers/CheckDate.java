/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Cuei.Entrada.Controllers;


import com.Cuei.Entrada.Databases.Cita.CitasService;
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
    CitasService citas;
    @GetMapping("/Entrada")
    public String entrada1(Model model, @RequestParam int n) {
        model.addAttribute("citas", citas.getByentradaByCitado(n));
        return "Entradas";
    }
}
