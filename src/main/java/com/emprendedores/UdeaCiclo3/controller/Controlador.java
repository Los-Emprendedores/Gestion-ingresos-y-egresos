package com.emprendedores.UdeaCiclo3.controller;

import com.emprendedores.UdeaCiclo3.Entidades.Empleado;
import com.emprendedores.UdeaCiclo3.Entidades.Empresa;
import com.emprendedores.UdeaCiclo3.service.EmpleadoService;
import com.emprendedores.UdeaCiclo3.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class Controlador {
    // Anotaciones
    @Autowired
    EmpresaService empresaService;
    @Autowired
    EmpleadoService empleadoService;

    // E M P R E S A S
    @GetMapping("/enterprises") // para ver JSON de todas la empresas
    public List<Empresa> verEmpresas(){
        return empresaService.getAllEmpresas();
    }

    @PostMapping("/enterprises") // Guardar el JSON del body como una nueva empresa o registro en la base de datos
    public Empresa guardarEmpresa(@RequestBody Empresa emp){
        return this.empresaService.saveUpdateEmpresa(emp);
    }

    @GetMapping (path = "/enterprises/{id}") // Consultar empresas por Id
    public Empresa empresaPorId(@PathVariable("id") Integer id){
        return this.empresaService.getEmpresaById(id);
    }

    @PatchMapping("/enterprises/{id}") // Actualizar (Patch) empresas por Id
    public Empresa actualizarEmpresa(@PathVariable("id") Integer id, @RequestBody Empresa empresa){
        Empresa emp=empresaService.getEmpresaById(id);
        emp.setNombre(empresa.getNombre());
        emp.setDireccion(empresa.getDireccion());
        emp.setTelefono(empresa.getTelefono());
        emp.setNIT(emp.getNIT());
        return empresaService.saveUpdateEmpresa(emp);
    }

    @DeleteMapping ("/enterprises/{id}") // Eliminar Registro de la base de datos}
    public String deleteEmpresa(@PathVariable("id") Integer id){
        boolean respuesta = this.empresaService.deleteEmpresa(id);
        if(respuesta){ // Si respuesta es true
            return "Se elimino la empresa con id " + id +" correctamente";
        }
        else{
            return "No se pudo eliminar la empresa con id " + id;
        }
    }

    // E M P L E A D O S
    @GetMapping ("/empleados") //ver JSON de todos los empleados
    public List<Empleado> verEmpleados(){
        return empleadoService.getAllEmpleados();
    }

    @PostMapping ("/empleados") // Guardar un enmpleado nuevo
    public Optional<Empleado> guardarEmpleado(@RequestBody Empleado empl){
        return Optional.ofNullable(this.empleadoService.saveUpdateEmpleado(empl));
    }

    @GetMapping ("/empleados/{id}") // Consultar Empleados por ID
    public Empleado empleadoPorId(@PathVariable("id") Integer id){
        return this.empleadoService.getEmpleadoById(id);
    }

    @GetMapping ("/enterprises/{id}/empleados") // Consultar empleados por empresa
    public ArrayList<Empleado> empleadoPorEmpresa(@PathVariable("id") Integer id){
        return this.empleadoService.obtenerPorEmpresa(id);

    }

}
