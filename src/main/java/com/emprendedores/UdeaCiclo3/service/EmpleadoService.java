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
    //Metodo para buscar empleados por empresa
    public ArrayList<Empleado> obtenerPorEmpresa(Integer id){
        return empleadoRepository.findByEmpresa(id);
    }


    //Metodo para guardar o actualizar objetos de tipo empleado
    public Empleado saveUpdateEmpleado(Empleado empleado){
        Empleado empl=empleadoRepository.save(empleado);
        return empl;
        }

    // Metodo para eliminar empleados registrados teniendo el id
    public boolean deleteEmpleado(Integer id){
        empleadoRepository.deleteById(id); // Eliminar
        if (empleadoRepository.findById(id) != null){ //Verificacion del servicio de eliminacion
            return true;
        }
        return false;
    }

} //Finaliza clase EmpleadoService
