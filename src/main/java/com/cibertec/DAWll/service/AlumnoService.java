package com.cibertec.DAWll.service;

import com.cibertec.DAWll.model.Alumno;
import com.cibertec.DAWll.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnoService {
    @Autowired
    private AlumnoRepository AlumnoRepo;

    public List<Alumno> listarAlumnos(){
        return AlumnoRepo.findAll();
    }

    public void registrarAlumno(Alumno alumno){
        AlumnoRepo.save(alumno);
    }

    public void eliminarAlumno(String idAlumno){
        AlumnoRepo.deleteById(idAlumno);
    }

    public String maxCodigoAlumno(){
        return AlumnoRepo.maxIdCode();
    }
}
