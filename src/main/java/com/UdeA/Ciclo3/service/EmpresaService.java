package com.UdeA.Ciclo3.service;

import com.UdeA.Ciclo3.repo.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.UdeA.Ciclo3.modelos.Empresa;

import java.util.ArrayList;
import java.util.List;


@Service
public class EmpresaService {
    @Autowired // Conectamos esta clase con el repository de empresa
    EmpresaRepository empresaRepository; // Creamos un objeto tipo EmpresaRepository

    // Metodo que retornara la lista de empresas usando metodos heredados del jpaRepository
    public List<Empresa> getAllEmpresas(){
        List<Empresa> empresaList = new ArrayList<>();
        empresaRepository.findAll().forEach(empresa -> empresaList.add(empresa)); // Recorreo el iterable que regresa el metodo
        // findAll
        return empresaList;
    }

    // Metodo que trae un objeto de tipo empresa cuando cuento con el ID de la misma
    public Empresa getEmpresaById(Integer id){
        return empresaRepository.findById(id).get();
    }

    // Metodo para guardar o actualizar objetos de tipo empresa
    public boolean saveOrUpdateEmpresa(Empresa empresa){
        Empresa emp = empresaRepository.save(empresa);
        if(empresaRepository.findById(emp.getId())!= null){
            return true;
        }
        return  false;
    }

    // Metodo para eliminar empresas registradas teniendo el ID
    public boolean deleteEmpresa (Integer id){
        empresaRepository.deleteById(id);
        if(getEmpresaById(id) != null){
            return false;
        }
        return  true;
    }
}
