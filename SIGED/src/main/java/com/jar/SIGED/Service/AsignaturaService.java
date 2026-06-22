package com.jar.SIGED.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jar.SIGED.Models.Entities.Asignatura;
import com.jar.SIGED.Repository.AsignaturaRepository;

@Service
public class AsignaturaService {

    @Autowired
    private AsignaturaRepository asignaturaRepository;

    public List<Asignatura> getAllAsignaturas(){
        return asignaturaRepository.findAll();
    }

    public Asignatura getAsignaturaById(Integer id){
        return asignaturaRepository.findById(id).orElse(null);
    }

    public Asignatura saveAsignatura(Asignatura asignatura){
        return asignaturaRepository.save(asignatura);
    }

    public Asignatura updateAsignatura(Asignatura asignatura){
        if(!asignaturaRepository.existsById(asignatura.getIdAsignatura())){
            return null;
        }
        return asignaturaRepository.save(asignatura);
    }

    public void deleteAsignatura(Integer id){
        asignaturaRepository.deleteById(id);
    }
}
