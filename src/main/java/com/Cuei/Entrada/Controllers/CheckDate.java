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
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author josue
 */
@Controller
public class CheckDate {
    @Autowired
    CitasService citas;
    @GetMapping("/Entrada_1")
    public String entrada1(Model model) {
        model.addAttribute("citas", citas.getByentradaByCitado(1));
        return "Entradas";
    }
    @GetMapping("/Entrada_2")
    public String entrada2(Model model) {
        model.addAttribute("citas", citas.getByentradaByCitado(2));
        return "Entradas";
    }
    @GetMapping("/Entrada_3")
    public String entrada3(Model model) {
        model.addAttribute("citas", citas.getByentradaByCitado(3));
        return "Entradas";
    }
}
