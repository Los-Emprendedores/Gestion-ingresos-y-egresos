package com.UdeA.Ciclo3.service;

import com.UdeA.Ciclo3.modelos.Empresa;
import com.UdeA.Ciclo3.repo.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpresaService {
    @Autowired
    EmpresaRepository empresaRepository;
    public List<Empresa> getAllEmpresas() {
        List<Empresa> empresaList = new ArrayList<>();
        empresaRepository.findAll().forEach(empresa->empresaList.add(empresa));
        return empresaList;

    }
    //Método que devuelve un objeto de tipo
    public Empresa getEmpresaById(Integer id) {
        return empresaRepository.findById(id).get();

    }
    //Método para guardar o Actualizar objetos tipo Empresa
    public boolean saveOrUpadateEmpresa(Empresa empresa) {
        Empresa emp = empresaRepository.save(empresa);

        if (empresaRepository.findById(emp.getId())!=null) {

            return true;
        }
        return false;

    }

    //Método Delete
    public boolean deleteEmpresa(Integer id) {
        empresaRepository.deleteById(id);
        if (getEmpresaById(id)!=null) {
            return false;
        }
        return true;


    }






}
