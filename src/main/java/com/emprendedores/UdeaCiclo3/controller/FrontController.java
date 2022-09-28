package com.emprendedores.UdeaCiclo3.controller;

// Importaciones

import com.emprendedores.UdeaCiclo3.Entidades.Empleado;
import com.emprendedores.UdeaCiclo3.Entidades.Empresa;
import com.emprendedores.UdeaCiclo3.Entidades.MovimientoDinero;
import com.emprendedores.UdeaCiclo3.service.EmpleadoService;
import com.emprendedores.UdeaCiclo3.service.EmpresaService;
import com.emprendedores.UdeaCiclo3.service.MovimientoDineroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller // Anotacion de controlador
public class FrontController { //Inicio Clase FrontController
    // Servicios Autowires
    @Autowired // Conexion a EmpresaService
    EmpresaService empresaService;
    @Autowired // Conexion a EmpleadoService
    EmpleadoService empleadoService;
    @Autowired // Conexion a MovimientoDineroService
    MovimientoDineroService movimientoService;

//----------------------------------------------------------------------------------------------------------------------
// Inicio
    @GetMapping("/index")
    public String index(Model model) {
        return "index";
    }
//----------------------------------------------------------------------------------------------------------------------

    // E M P R E S A S
    @GetMapping({"/VerEmpresas"})
    public String viewEmpresas(Model model, @ModelAttribute("mensaje") String mensaje) {
        List<Empresa> listaEmpresas = empresaService.getAllEmpresas();
        model.addAttribute("emplist", listaEmpresas);
        model.addAttribute("mensaje", mensaje);
        return "verEmpresas"; //Llamamos al HTML
    }

    // Controlador para crear empresa en la base de datos
    @GetMapping("/AgregarEmpresa")
    public String nuevaEmpresa(Model model, @ModelAttribute("mensaje") String mensaje) {
        Empresa emp = new Empresa();
        model.addAttribute("emp", emp);
        model.addAttribute("mensaje", mensaje);
        return "agregarEmpresa";
    }

    // Controlador para guardar empresa en la base de datos
    @PostMapping("/GuardarEmpresa")
    public String guardarEmpresa(Empresa emp, RedirectAttributes redirectAttributes) {
        if (empresaService.saveUpdateEmpresa(emp) == true) {
            redirectAttributes.addFlashAttribute("mensaje", "saveOK");
            return "redirect:/VerEmpresas";
        }
        redirectAttributes.addFlashAttribute("mensaje", "saveError");
        return "redirect:/AgregarEmpresa";
    }

    // Controlador para editar empresa en la base de datos
    @GetMapping("/EditarEmpresa/{id}")
    public String editarEmpresa(Model model, @PathVariable Integer id, @ModelAttribute("mensaje") String mensaje) {
        Empresa emp = empresaService.getEmpresaById(id);
        // Se creo atributo para el modelo, que se llame igualmente emp que iráal html para llenar los campos
        model.addAttribute("emp", emp);
        model.addAttribute("mensaje", mensaje);
        return "editarEmpresa";
    }

    // Controlador para actualizar la empresa en la base de datos
    @PostMapping("/ActualizarEmpresa")
    public String updateEmpresa(@ModelAttribute("emp") Empresa emp, RedirectAttributes redirectAttributes) {
        if (empresaService.saveUpdateEmpresa(emp)) {
            redirectAttributes.addFlashAttribute("mensaje", "updateOK");
            return "redirect:/VerEmpresas";
        }
        redirectAttributes.addFlashAttribute("mensaje", "updateError");
        return "redirect:/EditarEmpresa";
    }

    //Controlador para eliminar la empresa de la base
    @GetMapping("/EliminarEmpresa/{id}")
    public String eliminarEmpresa(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        if (empresaService.deleteEmpresa(id) == true) {
            redirectAttributes.addFlashAttribute("mensaje", "deleteOK");
            return "redirect:/VerEmpresas";
        }
        redirectAttributes.addFlashAttribute("mensaje", "deleteError");
        return "redirect:/VerEmpresas";
    }
//----------------------------------------------------------------------------------------------------------------------

// E M P L E A D O S

    @GetMapping({"/VerEmpleado"})
    public String viewEmpleado(Model model, @ModelAttribute("mensaje") String mensaje) {
        List<Empleado> listaEmpleado = empleadoService.getAllEmpleados();
        model.addAttribute("emplelist", listaEmpleado);
        model.addAttribute("mensaje", mensaje);
        return "verEmpleados"; //Llamamos al HTML
    }

    // Controlador para crear empleado en la base de datos
    @GetMapping("/AgregarEmpleado")
    public String nuevoEmpleado(Model model, @ModelAttribute("mensaje") String mensaje) {
        Empleado empl = new Empleado();
        model.addAttribute("empl", empl);
        model.addAttribute("mensaje", mensaje);
        List<Empresa> listaEmpresas = empresaService.getAllEmpresas();
        model.addAttribute("emprelist", listaEmpresas);
        return "agregarEmpleado";
    }

    // Controlador para guardar empleados en la base de datos
    @PostMapping("/GuardarEmpleado")
    public String guardarEmpleado(Empleado empl, RedirectAttributes redirectAttributes) {
        String passEncriptada = passwordEncoder().encode(empl.getPassword()); // encripta las contraseñas
        empl.setPassword(passEncriptada);
        if (empleadoService.saveUpdateEmpleado(empl) == true) {
            redirectAttributes.addFlashAttribute("mensaje", "saveOK");
            return "redirect:/VerEmpleado";
        }
        redirectAttributes.addFlashAttribute("mensaje", "saveError");
        return "redirect:/AgregarEmpleado";
    }

    // Controlador para editar empleados en la base de datos
    @GetMapping("/EditarEmpleado/{id}")
    public String editarEmpleado(Model model, @PathVariable Integer id, @ModelAttribute("mensaje") String mensaje) {
        Empleado empl = empleadoService.getEmpleadoById(id); //.get()
        //Creamos un atributo para el modelo, que se llame igualmente emp y es el que ira al html para llenar o alimentar campos
        model.addAttribute("empl", empl);
        model.addAttribute("mensaje", mensaje);
        List<Empresa> listaEmpresas = empresaService.getAllEmpresas();
        model.addAttribute("emprelist", listaEmpresas);
        return "editarEmpleado";
    }

    // Controlador para actualizar el empleado en la base de datos
    @PostMapping("/ActualizarEmpleado")
    public String updateEmpleado(@ModelAttribute("empl") Empleado empl, RedirectAttributes redirectAttributes) {
        Integer id=empl.getId(); //Saca el id del objeto empl
        String Oldpass=empleadoService.getEmpleadoById(id).getPassword();
        if(!empl.getPassword().equals(Oldpass)){
            String passEncriptada = passwordEncoder().encode(empl.getPassword()); // encripta las contraseñas
            empl.setPassword(passEncriptada);
        }
        if (empleadoService.saveUpdateEmpleado(empl)) {
            redirectAttributes.addFlashAttribute("mensaje", "updateOK");
            return "redirect:/VerEmpleado";
        }
        redirectAttributes.addFlashAttribute("mensaje", "updateError");
        return "redirect:/EditarEmpleado";
    }

    //Controlador para eliminar el empleado de la base de datos
    @GetMapping("/EliminarEmpleado/{id}")
    public String eliminarEmppleado(@PathVariable Integer id, RedirectAttributes redirectAttributes){
        if (empleadoService.deleteEmpleado(id)){
            redirectAttributes.addFlashAttribute("mensaje","deleteOK");
            return "redirect:/VerEmpleado";
        }
        redirectAttributes.addFlashAttribute("mensaje", "deleteError");
        return "redirect:/VerEmpleado";
    }

    @GetMapping("/Empresa/{id}/Empleados") //Filtrar los empleados por empresa
    public String verEmpleadosPorEmpresa(@PathVariable("id") Integer id, Model model) {
        List<Empleado> listaEmpleados = empleadoService.obtenerPorEmpresa(id);
        model.addAttribute("emplelist",listaEmpleados);
        return "verEmpleados"; //Llamamos al con el emplelist de los empleados filtrados
    }
//----------------------------------------------------------------------------------------------------------------------
    // M O V I M I E N T O S

// Controlador para ver los movimeintos existentes
@RequestMapping ("/VerMovimientos")// Controlador que nos lleva al template donde veremos todos los movimientos
public String viewMovimientos(Model model, @ModelAttribute("mensaje") String mensaje){
    List<MovimientoDinero> listaMovimientos= movimientoService.getAllMovimientos();
    model.addAttribute("movlist",listaMovimientos);
    model.addAttribute("mensaje",mensaje);
    Long sumaMonto=movimientoService.obtenerSumaMontos();
    model.addAttribute("SumaMontos",sumaMonto);//Mandamos la suma de todos los montos a la plantilla
    return "verMovimientos"; //Llamamos al HTML
    }
    //Controlador que nos lleva al template para crear movimientos
    @GetMapping("/AgregarMovimiento")
    public String nuevoMovimiento(Model model, @ModelAttribute("mensaje") String mensaje){
        MovimientoDinero movimiento= new MovimientoDinero();
        model.addAttribute("mov",movimiento);
        model.addAttribute("mensaje",mensaje);
        Authentication auth= SecurityContextHolder.getContext().getAuthentication();
        String email= auth.getName();
        Integer idEmpleado=movimientoService.IdPorCorreo(email);
        model.addAttribute("idEmpleado",idEmpleado);
        return "agregarMovimiento";
    }
// Controlador para gurdar loa movimientos realizados
    @PostMapping("/GuardarMovimiento")
    public String guardarMovimiento(MovimientoDinero mov, RedirectAttributes redirectAttributes){
        if(movimientoService.saveUpdateMovimiento(mov)==true){
            redirectAttributes.addFlashAttribute("mensaje","saveOK");
            return "redirect:/VerMovimientos";
        }
        redirectAttributes.addFlashAttribute("mensaje","saveError");
        return "redirect:/AgregarMovimiento";
    }
// Controlador para editar movimientos
    @GetMapping("/EditarMovimiento/{id}")
    public String editarMovimiento(Model model, @PathVariable Integer id, @ModelAttribute("mensaje") String mensaje){
        MovimientoDinero mov=movimientoService.getMovimientoDineroById(id);
        //Atributo para el modelo, emp,  ira al html para llenar o alimentar campos
        model.addAttribute("mov",mov);
        model.addAttribute("mensaje", mensaje);
        List<Empleado> listaEmpleados = empleadoService.getAllEmpleados();
        model.addAttribute("emplelist",listaEmpleados);

        return "editarMovimiento";
    }
// Controlador para actualizar movimientos realizados
    @PostMapping("/ActualizarMovimiento")
    public String updateMovimiento(@ModelAttribute("mov") MovimientoDinero mov, RedirectAttributes redirectAttributes){
        if(movimientoService.saveUpdateMovimiento(mov)){
            redirectAttributes.addFlashAttribute("mensaje","updateOK");
            return "redirect:/VerMovimientos";
        }
        redirectAttributes.addFlashAttribute("mensaje","updateError");
        return "redirect:/EditarMovimiento/"+mov.getId();

    }
// Controlador para eliminar movimientos realizados
    @GetMapping("/EliminarMovimiento/{id}")
    public String eliminarMovimiento(@PathVariable Integer id, RedirectAttributes redirectAttributes){
        if (movimientoService.deleteMovimiento(id)){
            redirectAttributes.addFlashAttribute("mensaje","deleteOK");
            return "redirect:/VerMovimientos";
        }
        redirectAttributes.addFlashAttribute("mensaje", "deleteError");
        return "redirect:/VerMovimientos";
    }
// Controlador para obtener movimientos por empleado
    @GetMapping("/Empleado/{id}/Movimientos")
    public String movimientosPorEmpleado(@PathVariable("id") Integer id, Model model) {

        List<MovimientoDinero> movlist = movimientoService.obtenerPorEmpleado(id);
        model.addAttribute("movlist", movlist);
        Long sumaMonto = movimientoService.MontosPorEmpleado(id);
        model.addAttribute("SumaMontos",sumaMonto);
        return "verMovimientos";


    }

// Controlador para Obtener movivmientos por empresa
    @GetMapping("/Empresa/{id}/Movimientos")
    public String movimientosPorEmpresa(@PathVariable("id") Integer id, Model model) {
        List<MovimientoDinero> movlist = movimientoService.obtenerPorEmpresa(id);
        model.addAttribute("movlist", movlist);
        Long sumaMonto = movimientoService.MontosPorEmpresa(id);
        model.addAttribute("SumaMontos",sumaMonto);
        return "verMovimientos";

    }

//----------------------------------------------------------------------------------------------------------------------
    // Controlador para acceso denegado
    @RequestMapping(value = "/Denegado")
    public String accesoDenegado(){
        return "accessDenied";
    }


//----------------------------------------------------------------------------------------------------------------------
    // Encriptar Contraseñas
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

} // Fin clase FrontController

