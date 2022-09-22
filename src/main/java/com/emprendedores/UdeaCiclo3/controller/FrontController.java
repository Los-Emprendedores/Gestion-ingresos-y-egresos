package com.emprendedores.UdeaCiclo3.controller;

import com.emprendedores.UdeaCiclo3.Entidades.Empresa;
import com.emprendedores.UdeaCiclo3.service.EmpleadoService;
import com.emprendedores.UdeaCiclo3.service.EmpresaService;
import com.emprendedores.UdeaCiclo3.service.MovimientoDineroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

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

    @GetMapping("/verEmpresas")
    public String lista(Model model){
        List<Empresa> listaEmpresas=empresaService.getAllEmpresas();
        model.addAttribute("emplist", listaEmpresas);
        return "verEmpresas";
    }

    // Controlador para crear empresa en la base de datos
    @GetMapping("/AgregarEmpresa")
    public String nuevaEmpresa(Model model, @ModelAttribute("mensaje") String mensaje){
        Empresa emp = new Empresa();
        model.addAttribute("emp", emp);
        model.addAttribute("mensaje", mensaje);
        return "agregarEmpresa";
    }
    // Controlador para guardar empresa en la base de datos
    /*@PostMapping("/GuardarEmpresa")
    public String guardarEmpresa(Empresa emp, RedirectAttributes redirectAttributes){
        if (empresaService.saveUpdateEmpresa(emp)==true){
            redirectAttributes.addFlashAttribute("mensaje", "saveOK");
            return "redirect:/VerEmpresas";
        }
        redirectAttributes.addFlashAttribute("mensaje", "saveError");
        return "redirect:/AgregarEmpresa";
    }*/

    // Controlador para editar empresa en la base de datos
    @GetMapping("/EditarEmpresa/{id}")
    public String editarEmpresa(Model model, @PathVariable Integer id, @ModelAttribute("mensaje") String mensaje){
        Empresa emp=empresaService.getEmpresaById(id);
        // Se creo atributo para el modelo, que se llame igualmente emp que iráal html para llenar los campos
        model.addAttribute("emp", emp);
        model.addAttribute("mensaje", mensaje);
        return "editarEmpresa";
    }

    // Controlador para actualizar la empresa en la base de datos
    /*@PostMapping("/ActualizarEmpresa")
    public String actualizarEmpresa(@ModelAttribute("emp") Empresa emp,RedirectAttributes redirectAttributes){
        if (empresaService.saveUpdateEmpresa(emp)){
            redirectAttributes.addFlashAttribute("mensaje", "updateOK");
            return "redirect:/VerEmpresas";
        }
        redirectAttributes.addFlashAttribute("mensaje", "updateError");
        return "redirect:/EditarEmpresa";
    }*/

    //Controlador para eliminar la empresa de la base
    @GetMapping("/EliminarEmpresa/{id}")
    public String eliminarEmpresa(@PathVariable Integer id, RedirectAttributes redirectAttributes){
        if (empresaService.deleteEmpresa(id)==true){
            redirectAttributes.addFlashAttribute("mensaje","deleteOK");
            return "redirect:/VerEmpresas";
        }
        redirectAttributes.addFlashAttribute("mensaje", "deleteError");
        return "redirect:/VerEmpresas";
    }
}

