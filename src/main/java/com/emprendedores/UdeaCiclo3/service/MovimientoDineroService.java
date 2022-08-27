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

    public boolean saveUpdateMovimientoDinero(MovimientoDinero movimientoDinero){
        MovimientoDinero mov=movimientoDineroRepository.save(movimientoDinero);
        if(movimientoDineroRepository.findById(mov.getId())!=null){
            return true;
        }
        return false;
    }

}
