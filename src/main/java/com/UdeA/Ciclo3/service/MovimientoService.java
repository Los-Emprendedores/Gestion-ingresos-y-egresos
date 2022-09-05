package com.UdeA.Ciclo3.service;

import com.UdeA.Ciclo3.modelos.MovimientoDinero;
import com.UdeA.Ciclo3.repo.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovimientoService {
    @Autowired
    MovimientoRepository movimientoRepository;
    //Ver todos los movimientos
    public List<MovimientoDinero> getAllMovimientos() {
        List<MovimientoDinero> movimientosList = new ArrayList<>();
        movimientoRepository.findAll().forEach(movimiento->movimientosList.add(movimiento));
        return movimientosList;
    }
    //Consultar movimientos por id
    public MovimientoDinero getMovimientoById(Integer id) {
        return movimientoRepository.findById(id).get();
    }
    //Guardar Movimientos
    public MovimientoDinero saveOrUpdateMovimiento(MovimientoDinero movimientoDinero) {
        MovimientoDinero mov = movimientoRepository.save(movimientoDinero);
        return mov;
    }
    //Eliminar movimientos
    public boolean deleteMovimiento(Integer id) {
        movimientoRepository.deleteById(id);
        if (movimientoRepository.findById(id).isPresent()) {
            return false;
        }
        return true;
    }
    //Filtro por empleado
    public ArrayList<MovimientoDinero> obtenerPorEmpledo(Integer id) {
        return movimientoRepository.findByEmpleado(id);
    }
    //Filtro por Empresa
    public ArrayList<MovimientoDinero> obtenerPorEmpresa(Integer id) {
        return movimientoRepository.findByEmpresa(id);
    }

}
