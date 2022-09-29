package com.emprendedores.UdeaCiclo3.service;

import com.emprendedores.UdeaCiclo3.Entidades.MovimientoDinero;
import com.emprendedores.UdeaCiclo3.repo.MovimientoDineroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service //Anotacion que indica que es un servicio
public class MovimientoDineroService {

    @Autowired // Conecta la clase con el repositorio MovimientoDineroRepository
    MovimientoDineroRepository movimientoDineroRepository;
    public List<MovimientoDinero> getAllMovimientos(){
        List<MovimientoDinero> movimientoDineroList = new ArrayList<>(); // Se creo lista movimientoDineroList
        // Recorre el iterable que regresa el metodo findAll del Jpa y se guarda en la lista
        movimientoDineroRepository.findAll().forEach(movimientoDinero ->  movimientoDineroList.add(movimientoDinero));
        return movimientoDineroList;
    }

    //Metodo que trae un objeto de tipo movimientoDinero cuando se tiene el id
    public MovimientoDinero getMovimientoDineroById(Integer id){
        return movimientoDineroRepository.findById(id).get();
    }

    //Metodo para guardar o actualizar objetos de tipo movimientoDinero

    public boolean saveUpdateMovimiento(MovimientoDinero movimientoDinero){ //Guardar o actualizar elementos
        MovimientoDinero mov=movimientoDineroRepository.save(movimientoDinero);
        if (movimientoDineroRepository.findById(mov.getId())!=null){
            return true;
        }
        return false;
    }

    public boolean deleteMovimiento(Integer id){ //Eliminar movimiento con id
        movimientoDineroRepository.deleteById(id); // Eliminar
        if (movimientoDineroRepository.findById(id) != null){ //Verificacion del servicio de eliminacion
            return true;
        }
        return false;
    }

    public ArrayList<MovimientoDinero> obtenerPorEmpleado(Integer id) { // se obtiene teniendo en cuenta el id del empleado
        return this.movimientoDineroRepository.findByEmpleado(id);
    }

    public ArrayList<MovimientoDinero> obtenerPorEmpresa(Integer id){ // se obtiene teniendo en cuenta el id de la empresa a la que pertenece el empleado
        return this.movimientoDineroRepository.findByEmpresa(id);
    }

    //Servicio para ver la suma de todos los montos
    public Long obtenerSumaMontos() {
        return movimientoDineroRepository.SumaMonto();
    }
    public Long MontosPorEmpleado(Integer id) {
        return movimientoDineroRepository.MontosPorEmpleado(id);
    }
    public Long MontosPorEmpresa(Integer id) {
        return movimientoDineroRepository.MontosPorEmpresa(id);
    }

    // Servicio que permite conseguir el id de un empleado si tenemos el corre
    public Integer IdPorCorreo(String Email){
        return movimientoDineroRepository.idPorEmail(Email);
    }
}
