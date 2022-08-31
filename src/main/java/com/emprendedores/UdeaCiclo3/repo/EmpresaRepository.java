package com.emprendedores.UdeaCiclo3.repo;

import com.emprendedores.UdeaCiclo3.Entidades.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Anotacion que dice a Spring que esta clase es un repositorio
public interface EmpresaRepository extends JpaRepository <Empresa, Integer>{
}
