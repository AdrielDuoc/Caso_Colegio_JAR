package com.jar.SIGED.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jar.SIGED.Models.Entities.Curso;
import com.jar.SIGED.Repository.CursoRepository;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public List<Curso> getAllCursos(){
        return cursoRepository.findAll();
    }

    public Curso getCursoById(Integer id){
        return cursoRepository.findById(id).orElse(null);
    }

    public Curso saveCurso(Curso curso){
        return cursoRepository.save(curso);
    }

    public Curso updateCurso(Curso curso){
        if(!cursoRepository.existsById(curso.getIdCurso())){
            return null;
        }
        return cursoRepository.save(curso);
    }

    public void deleteCurso(Integer id){
        cursoRepository.deleteById(id);
    }
}
