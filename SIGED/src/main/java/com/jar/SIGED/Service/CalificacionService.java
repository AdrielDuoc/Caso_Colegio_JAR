package com.jar.SIGED.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jar.SIGED.Models.Entities.Calificacion;
import com.jar.SIGED.Repository.CalificacionRepository;

@Service
public class CalificacionService {

    @Autowired
    private CalificacionRepository calificacionRepository;

    public List<Calificacion> getAllCalificacion(){
        return calificacionRepository.findAll();
    }

    public Calificacion getCalificacionById(Integer id){
        return calificacionRepository.findById(id).orElse(null);
    }

    public Calificacion saveCalificacion(Calificacion calificacion){
        return calificacionRepository.save(calificacion);
    }

    public Calificacion updateCalificacion(Calificacion calificacion){
        if(!calificacionRepository.existsById(calificacion.getIdCalificacion())){
            return null;
        }
        return calificacionRepository.save(calificacion);
    }

    public void deleteCalificacion(Integer id){
        calificacionRepository.deleteById(id);
    }
}
