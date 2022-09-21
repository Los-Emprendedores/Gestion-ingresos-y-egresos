package com.emprendedores.UdeaCiclo3.controller;

import com.emprendedores.UdeaCiclo3.service.EmpleadoService;
import com.emprendedores.UdeaCiclo3.service.EmpresaService;
import com.emprendedores.UdeaCiclo3.service.MovimientoDineroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontController {
    // Servicios Autowires
    @Autowired
    EmpresaService empresaService;
    @Autowired
    EmpleadoService empleadoService;
    @Autowired
    MovimientoDineroService movimientoDineroService;

    @GetMapping("/index")
    public String index (Model model){
        return "index";
    }

    @GetMapping("/home")
    public String home (){
        return "home";
    }


}
