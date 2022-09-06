package com.UdeA.Ciclo3.controller;


import com.UdeA.Ciclo3.modelos.Empleado;
import com.UdeA.Ciclo3.modelos.Empresa;
import com.UdeA.Ciclo3.modelos.MovimientoDinero;
import com.UdeA.Ciclo3.repo.MovimientoRepository;
import com.UdeA.Ciclo3.service.EmpleadoService;
import com.UdeA.Ciclo3.service.EmpresaService;
import com.UdeA.Ciclo3.service.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ControllerFull {
    @Autowired
    EmpresaService  empresaService;
    @Autowired
    EmpleadoService empleadoService;
    @Autowired
    MovimientoService movimientoService;

    @GetMapping("/enterprises") //Ver json de todas las empresas
    public List<Empresa> verEmpresas(){
        return empresaService.getAllEmpresas();
    }

    @PostMapping("/enterprises") //Guardar el json del body como una nueva empresa o registro en nuestra bd
    public Empresa guardarEmpresa(@RequestBody Empresa emp){
        return this.empresaService.saveOrUpdateEmpresa(emp);
    }

    @GetMapping(path = "enterprises/{id}")
    public Empresa empresaPorID(@PathVariable("id") Integer id){
        return this.empresaService.getEmpresaById(id);
    }

    @PatchMapping("/enterprises/{id}")
    public Empresa actualizarEmpresa(@PathVariable("id") Integer id, @RequestBody Empresa empresa){
        Empresa emp= empresaService.getEmpresaById(id);
        emp.setNombre(empresa.getNombre());
        emp.setDireccion(empresa.getDireccion());
        emp.setTelefono(empresa.getTelefono());
        emp.setNIT(empresa.getNIT());
        return empresaService.saveOrUpdateEmpresa(emp);

    }

    @DeleteMapping (path= "enterprises/{id}") //Eliminar registro de la bd
    public String DeleteEmpresa(@PathVariable("id") Integer id){
        boolean respuesta= this.empresaService.deleteEmpresa(id);
        if (respuesta){  //Si respuesta es true?
            return "Se elimino la empresa con id" +id;
        }
        else{
            return "No se pudo eliminar la empresa con id"+id;
        }
    }

    //Empleados
    //Ver todos los empleados
    @GetMapping("/users") //Ver json de todas las empresas
    public List<Empleado> verEmpleados(){
        return empleadoService.getAllEmpleado();
    }
    //Guardar Empleado
    @PostMapping("/users")
    public Optional<Empleado> guardarEmpleado(@RequestBody Empleado empl) {
        return Optional.ofNullable(empleadoService.saveOrUpdateEmpleado(empl));
    }
    //Empleado por Id
    @GetMapping("/users/{id}")
    public Optional<Empleado> empleadoPorId(@PathVariable("id") Integer id) {
        return empleadoService.getEmpleadoById(id);
    }

    @GetMapping("/enterprises/{id}/empleados")
    public ArrayList<Empleado> EmpleadosPorEmpresa(@PathVariable("id") Integer id) {
        return empleadoService.obtenerPorEmpresa(id);
    }

    @PatchMapping("/users/{id}")
    public Empleado actualizarEmpleado(@PathVariable("id") Integer id, @RequestBody Empleado empleado) {
        Empleado empl = empleadoService.getEmpleadoById(id).get();
        empl.setNombre(empleado.getNombre());
        empl.setCorreo(empleado.getCorreo());
        empl.setEmpresa(empleado.getEmpresa());
        empl.setRol(empleado.getRol());
        return empleadoService.saveOrUpdateEmpleado(empl);
    }
    //Borrar Empleado
    @DeleteMapping("/users/{id}")
    public String deleteEmpleado(@PathVariable("id") Integer id) {
        empleadoService.deleteEmpleado(id);
        if (empleadoService.getEmpleadoById(id).isPresent()) {
            return "Usuario no eliminado con id: "+ id;
        } else {
            return "Usuario eliminado satisfactoriamente con id: "+ id;
        }
    }
    //Movimientos

    @GetMapping("/movements")
    public List<MovimientoDinero> verMovimientos() {
        return movimientoService.getAllMovimientos();
    }
    @PostMapping("/movements")
    public MovimientoDinero guardarMovimiento(@RequestBody MovimientoDinero movimiento) {
        return movimientoService.saveOrUpdateMovimiento(movimiento);
    }
    @GetMapping("/movements/{id}")
    public MovimientoDinero movimientoPorId(@PathVariable("id") Integer id) {
        return movimientoService.getMovimientoById(id);
    }
    @PatchMapping("/movements/{id}")
    public MovimientoDinero actualizarMovimiento(@PathVariable("id") Integer id, @RequestBody MovimientoDinero movimiento) {
        MovimientoDinero mov = movimientoService.getMovimientoById(id);
        mov.setConcepto(movimiento.getConcepto());
        mov.setMonto(movimiento.getMonto());
        mov.setUsuario(movimiento.getUsuario());
        return movimientoService.saveOrUpdateMovimiento(mov);
    }
    @DeleteMapping("/movements/{id}")
    public String borrarMovimiento(@PathVariable("id") Integer id) {
        boolean movimiento_eliminado = movimientoService.deleteMovimiento(id);
        if (movimiento_eliminado) {
            return "Eliminado el movimiento con id: " + id;
        }
        return "El movimiento con id: " + id + " no pudo ser eliminado";

    }
    //Consulta usuarios y movimientos
    @GetMapping("/users/{id}/movements")
    public ArrayList<MovimientoDinero> movimientosPorEmpleado(@PathVariable("id") Integer id) {
        return movimientoService.obtenerPorEmpledo(id);

    }
    //Consulta empresas por movimientos
    @GetMapping("/enterprices/{id}/movements")
    public ArrayList<MovimientoDinero> movimientosPorEmpresa(@PathVariable("id") Integer id) {
        return movimientoService.obtenerPorEmpresa(id);
    }
}
