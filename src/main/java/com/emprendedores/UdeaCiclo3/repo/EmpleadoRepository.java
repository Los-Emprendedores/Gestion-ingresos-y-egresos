package com.emprendedores.UdeaCiclo3.repo;

import com.emprendedores.UdeaCiclo3.Entidades.Empleado;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository // Anotacion que dice a Spring que esta clase es un repositorio
public interface EmpleadoRepository extends CrudRepository<Empleado,Integer> {
    @Query(value="SELECT * FROM empleado WHERE empresa_id= ?1", nativeQuery = true)
    public abstract ArrayList<Empleado> findByEmpresa(Integer id);
}
