package com.emprendedores.UdeaCiclo3.repo;

import com.emprendedores.UdeaCiclo3.Entidades.MovimientoDinero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository // Anotacion que dice a Spring que esta clase es un repositorio
public interface MovimientoDineroRepository extends JpaRepository<MovimientoDinero, Integer> {
    // Metodo para filtrar movimientos por empleado
    @Query(value = "SELECT * FROM movimientos WHERE empleado_id= ?1", nativeQuery = true)
    public abstract ArrayList<MovimientoDinero> findByEmpleado(Integer id);

    // Metodo para filtrar movimientos por empresa
    @Query(value = "SELECT * FROM movimientos WHERE empleado_id in (SELECT id FROM empleado WHERE empresa_id = ?1)", nativeQuery = true)
    public abstract ArrayList<MovimientoDinero> findByEmpresa(Integer id);
}
