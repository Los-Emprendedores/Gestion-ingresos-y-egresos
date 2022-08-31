package com.emprendedores.UdeaCiclo3.service;

import com.emprendedores.UdeaCiclo3.Entidades.Empresa;
import com.emprendedores.UdeaCiclo3.repo.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service //Clase de servicios
public class EmpresaService { //Inicio clase EmpresaService
    @Autowired //Conectar la clase con el repositorio de Empresa
    EmpresaRepository empresaRepository; //Objeto tipo EmpresaRepository para usar metodos de la clase

    public List<Empresa> getAllEmpresas(){
        List<Empresa> empresaList = new ArrayList<>(); // Se creo lista empresaList
        // Recorre el iterable que regresa el metodo findAll del Jpa y se guarda en la lista
        empresaRepository.findAll().forEach(empresa ->  empresaList.add(empresa));
        return empresaList;
    }

    //Metodo que trae un objeto de tipo Empresa cuando se tiene el id
    public Empresa getEmpresaById(Integer id){
        return empresaRepository.findById(id).get();
    }

    //Metodo para guardar o actualizar objetos de tipo empresa

    public boolean saveUpdateEmpresa(Empresa empresa){
        Empresa emp=empresaRepository.save(empresa);
        if(empresaRepository.findById(emp.getId())!=null){
            return true;
        }
        return false;
    }

    // Metodo para eliminar empresas registradas teniendo el id
    public boolean deleteEmpresa(Integer id){
        empresaRepository.deleteById(id);
        if(getEmpresaById(id)!= null){
            return false;
        }
        return true;
    }

}
