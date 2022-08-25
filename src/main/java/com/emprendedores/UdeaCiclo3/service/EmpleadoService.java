package com.emprendedores.UdeaCiclo3.service;

import com.emprendedores.UdeaCiclo3.repo.EmpleadoRepository;
import com.emprendedores.UdeaCiclo3.repo.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //Clase de servicios
public class EmpleadoService { // Inicio Clase EmpleadoService

    @Autowired //Conectar la clase con el repositorio de Empleado
    EmpleadoRepository empleadoRepository; //Objeto tipo EmpleadoRepository para usar metodos de la clase
}
// hola mundo