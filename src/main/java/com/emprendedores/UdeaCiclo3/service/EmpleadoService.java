package com.emprendedores.UdeaCiclo3.service;

import com.emprendedores.UdeaCiclo3.Entidades.Empleado;
import com.emprendedores.UdeaCiclo3.repo.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service //Clase de servicios
public class EmpleadoService { // Inicio Clase EmpleadoService

    @Autowired //Conectar la clase con el repositorio de Empleado
    EmpleadoRepository empleadoRepository; //Objeto tipo EmpleadoRepository para usar metodos de la clase

    public List<Empleado> getAllEmpleados(){
        List<Empleado> empleadoList = new ArrayList<>(); // Se creo lista empleadoList
        // Recorre el iterable que regresa el metodo findAll del Jpa y se guarda en la lista
        empleadoRepository.findAll().forEach(empleado ->  empleadoList.add(empleado));
        return empleadoList;
    }

    //Metodo que trae un objeto de tipo Empresa cuando se tiene el id
    public Empleado getEmpleadoById(Integer id){
        return empleadoRepository.findById(id).get();
    }

    //Metodo para guardar o actualizar objetos de tipo empleado

    public boolean saveUpdateEmpleado(Empleado empleado){
        Empleado empl=empleadoRepository.save(empleado);
        if(empleadoRepository.findById(empl.getId())!=null){
            return true;
        }
        return false;
    }

    // Metodo para eliminar empleados registrados teniendo el id
    public boolean deleteEmpleado(Integer id){
        empleadoRepository.deleteById(id);
        if(getEmpleadoById(id)!= null){
            return false;
        }
        return true;
    }

} //Finaliza clase EmpleadoService
