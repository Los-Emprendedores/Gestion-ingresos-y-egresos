/* package com.emprendedores.UdeaCiclo3.controller;

import com.emprendedores.UdeaCiclo3.Entidades.Empleado;
import com.emprendedores.UdeaCiclo3.Entidades.Empresa;
import com.emprendedores.UdeaCiclo3.Entidades.MovimientoDinero;
import com.emprendedores.UdeaCiclo3.service.EmpleadoService;
import com.emprendedores.UdeaCiclo3.service.EmpresaService;
import com.emprendedores.UdeaCiclo3.service.MovimientoDineroService;
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

    @Autowired
    MovimientoDineroService movimientoDineroService;

    // E M P R E S A S
    @GetMapping("/enterprises") // para ver JSON de todas la empresas
    public List<Empresa> verEmpresas() {
        return empresaService.getAllEmpresas();
    }

    @PostMapping("/enterprises") // Guardar el JSON del body como una nueva empresa o registro en la base de datos
    public Empresa guardarEmpresa(@RequestBody Empresa emp) {
        return this.empresaService.saveUpdateEmpresa(emp);
    }

    @GetMapping(path = "/enterprises/{id}") // Consultar empresas por Id
    public Empresa empresaPorId(@PathVariable("id") Integer id) {
        return this.empresaService.getEmpresaById(id);
    }

    @PatchMapping("/enterprises/{id}") // Actualizar (Patch) empresas por Id
    public Empresa actualizarEmpresa(@PathVariable("id") Integer id, @RequestBody Empresa empresa) {
        Empresa emp = empresaService.getEmpresaById(id);
        emp.setNombre(empresa.getNombre());
        emp.setDireccion(empresa.getDireccion());
        emp.setTelefono(empresa.getTelefono());
        emp.setNIT(emp.getNIT());
        return empresaService.saveUpdateEmpresa(emp);
    }

    @DeleteMapping("/enterprises/{id}") // Eliminar Registro de la base de datos}
    public String deleteEmpresa(@PathVariable("id") Integer id) {
        boolean respuesta = this.empresaService.deleteEmpresa(id);
        if (respuesta) { // Si respuesta es true
            return "Se eliminó la empresa con id " + id + " correctamente";
        } else {
            return "No se pudo eliminar la empresa con id " + id;
        }
    }

    // E M P L E A D O S
    @GetMapping("/empleados") //ver JSON de todos los empleados
    public List<Empleado> verEmpleados() {
        return empleadoService.getAllEmpleados();
    }

    @PostMapping("/empleados") // Guardar un enmpleado nuevo
    public Optional<Empleado> guardarEmpleado(@RequestBody Empleado empl) {
        return Optional.ofNullable(this.empleadoService.saveUpdateEmpleado(empl));
    }

    @GetMapping("/empleados/{id}") // Consultar Empleados por ID
    public Empleado empleadoPorId(@PathVariable("id") Integer id) {
        return this.empleadoService.getEmpleadoById(id);
    }

    @GetMapping("/enterprises/{id}/empleados") // Consultar empleados por empresa
    public ArrayList<Empleado> empleadoPorEmpresa(@PathVariable("id") Integer id) {
        return this.empleadoService.obtenerPorEmpresa(id);
    }

    @PatchMapping("/empleados/{id}") // Actualizar (Patch) empresas por Id
    public Empleado actualizarEmpleado(@PathVariable("id") Integer id, @RequestBody Empleado empleado) {
        Empleado empl = empleadoService.getEmpleadoById(id);
        empl.setNombre(empleado.getNombre());
        empl.setEmail(empleado.getEmail());
        empl.setEmpresa(empleado.getEmpresa());
        empl.setRol(empleado.getRol());
        return empleadoService.saveUpdateEmpleado(empl);
    }

    @DeleteMapping("/empleados/{id}") // Eliminar empleados por Id
    public String DeleteEmpleado(@PathVariable("id") Integer id) {
        boolean respuesta = this.empleadoService.deleteEmpleado(id); // Eliminamos usando el servicio de service
        if (respuesta) { // Si respuesta es true se elimina
            return "Se eliminó el empleado con id " + id + " correctamente";
        } else { // Si respuesta es false no se elimina
            return "No se pudo eliminar el empleado con id " + id;
        }
    }

    // M O V I M I E N T O S - D I N E R O
    @GetMapping("/movimientos") // consultar todos los movimientos
    public List<MovimientoDinero> verMovimientos() {
        return movimientoDineroService.getAllMovimientos();
    }

    @PostMapping("/movimientos") // Guardar un movimiento nuevo
    public MovimientoDinero guardarMovimiento(@RequestBody MovimientoDinero movimiento) {
        return movimientoDineroService.saveUpdateMovimiento(movimiento);
    }

    @GetMapping("/movimientos/{id}") // Consultar movimiento por id
    public MovimientoDinero movimientoPorId(@PathVariable("id") Integer id) {
        return this.movimientoDineroService.getMovimientoDineroById(id);
    }

    @PatchMapping("/movimientos/{id}") // Editar o actualizar movimientos
    public MovimientoDinero actualizarMovimiento(@PathVariable("id") Integer id, @RequestBody MovimientoDinero movimiento) {
        MovimientoDinero mov = movimientoDineroService.getMovimientoDineroById(id);
        mov.setConcepto(movimiento.getConcepto());
        mov.setMonto(movimiento.getMonto());
        mov.setUsuario(movimiento.getUsuario());
        return movimientoDineroService.saveUpdateMovimiento(mov);
    }

    @DeleteMapping("/movimientos/{id}") // Eliminar movimientos por Id
    public String DeleteMovimiento(@PathVariable("id") Integer id) {
        boolean respuesta = this.movimientoDineroService.deleteMovimiento(id); // Eliminamos usando el servicio de service
        if (respuesta) { // Si respuesta es true se elimina
            return "Se eliminó el movimiento con id " + id + " correctamente";
        } else { // Si respuesta es false no se elimina
            return "No se pudo eliminar el movimiento con id " + id;
        }
    }

    @GetMapping("/empleados/{id}/movimientos") // Consultar movimientos por id del empleado
    public ArrayList<MovimientoDinero> movimientoPorEmpleado(@PathVariable ("id") Integer id){
        return movimientoDineroService.obtenerPorEmpleado(id);
    }

    @GetMapping("/enterprises/{id}/movimientos")// Consultar movimientos por id de empresa
    public ArrayList<MovimientoDinero> movimientoPorEmpresa(@PathVariable("id") Integer id){
        return  movimientoDineroService.obtenerPorEmpresa(id);
    }
}*/