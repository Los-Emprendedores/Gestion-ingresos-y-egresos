package com.UdeA.Ciclo3.service;

import com.UdeA.Ciclo3.modelos.Empleado;
import com.UdeA.Ciclo3.repo.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService {
    @Autowired
    EmpleadoRepository empleadoRepository;
    //Método para buscar todos los empleados
    public List<Empleado> getAllEmpleado() {
        List<Empleado> empleadoList=new ArrayList<>();
        empleadoRepository.findAll().forEach((empleado -> empleadoList.add(empleado)));
        return empleadoList;
    }

    //Método para buscar empleados por ID
    public Optional<Empleado> getEmpleadoById(Integer id) {
        return empleadoRepository.findById(id);
    }

    //Método para buscar empleados por empresa
    public ArrayList<Empleado> obtenerPorEmpresa(Integer id) {
        return empleadoRepository.findByEmpresa(id);
    }



    //Método para guardar o actualizar registros en Empleados
    public Empleado saveOrUpdateEmpleado(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }
    //Método para eliminar un empleado
    public boolean deleteEmpleado(Integer id) {
        empleadoRepository.deleteById(id);
        if(empleadoRepository.findById(id).isPresent()) {
            return false;
        }
        return true;
    }

}
