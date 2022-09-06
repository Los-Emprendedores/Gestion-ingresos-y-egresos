package com.UdeA.Ciclo3.repo;

import com.UdeA.Ciclo3.modelos.MovimientoDinero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface MovimientoRepository extends JpaRepository<MovimientoDinero, Integer> {
    //Método para filtar movimientos por empleado
    @Query(value="select * from movimientos where empleado_id=?1",nativeQuery = true)
    public abstract ArrayList<MovimientoDinero> findByEmpleado(Integer id);
    //Método para filtrar movimiento por empresa
    @Query(value="select * from movimientos where empleado_id in (select id from empleado where empresa_id=?1)",nativeQuery = true)
    public abstract ArrayList<MovimientoDinero> findByEmpresa(Integer id);

}
