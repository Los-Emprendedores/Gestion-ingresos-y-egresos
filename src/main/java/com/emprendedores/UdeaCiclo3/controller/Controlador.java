/* package com.emprendedores.UdeaCiclo3.controller;

import com.emprendedores.UdeaCiclo3.Entidades.Empresa;
import com.emprendedores.UdeaCiclo3.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

//@RestController
@Controller
public class Controlador {

    @Autowired
    EmpresaService empresaService;

    @GetMapping ({"/","/VerEmpresas"})
    public String viewEmpresas(Model model){
        List<Empresa> listaEmpresas=empresaService.getAllEmpresas();
        model.addAttribute("emplist", listaEmpresas);
        return "verEmpresas"; // Llama a HTML
    }
    // Controlador para crear empresa en la base de datos
    @GetMapping("/AgregarEmpresa")
    public String nuevaEmpresa(Model model){
        Empresa emp = new Empresa();
        model.addAttribute("emp", emp);
        return "agregarEmpresa";
    }
    // Controlador para guardar empresa en la base de datos
    @PostMapping("/GuardarEmpresa")
    public String guardarEmpresa(Empresa emp, RedirectAttributes redirectAttributes){
        if (empresaService.saveUpdateEmpresa(emp)==true){
            return "redirect:/VerEmpresas";
        }
        return "redirect:/AgregarEmpresa";
    }

    // Controlador para editar empresa en la base de datos
    @GetMapping("/EditarEmpresa/{id}")
    public String editarEmpresa(Model model, @PathVariable Integer id){
        Empresa emp=empresaService.getEmpresaById(id);
        // Se creo atributo para el modelo, que se llame igualmente emp que iráal html para llenar los campos
        model.addAttribute("emp", emp);
        return "editarEmpresa";
    }

    // Controlador para actualizar la empresa en la base de datos
    @PostMapping("/ActualizarEmpresa")
    public String actualizarEmpresa(@ModelAttribute("emp") Empresa emp){
        if (empresaService.saveUpdateEmpresa(emp)==true){
            return "redirect:/VerEmpresas";
        }
        return "redirect:/EditarEmpresa";
    }

    //Controlador para eliminar la empresa de la base
    @GetMapping("/EliminarEmpresa/{id}")
    public String eliminarEmpresa(@PathVariable Integer id){
        try {
            empresaService.deleteEmpresa(id);
        }
        catch (Exception e){
            return "redirect:/VerEmpresas";
        }
        return "redirect:/VerEmpresas";
    }
} */
