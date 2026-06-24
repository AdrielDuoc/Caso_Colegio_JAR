package com.jar.SIGED.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jar.SIGED.Models.Entities.Docente;
import com.jar.SIGED.Repository.DocenteRepository;


@Service
public class DocenteService {

    @Autowired
    private DocenteRepository docenteRepository;

    public List<Docente> getAllDocentes(){
        return docenteRepository.findAll();
    }

    public Docente getDocenteById(Integer id){
        return docenteRepository.findById(id).orElse(null);
    }

    public Docente saveDocente(Docente docente){
        return docenteRepository.save(docente);
    }

    public Docente updateDocente(Docente docente){
        if(!docenteRepository.existsById(docente.getIdDocente())){
            return null;
        }
        return docenteRepository.save(docente);
    }

    public void deleteDocente(Integer id){
        docenteRepository.deleteById(id);
    }
}
