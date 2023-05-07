package com.cibertec.DAWll.service;

import com.cibertec.DAWll.model.Especialidad;
import com.cibertec.DAWll.repository.EspecialidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspecialidadService {
    @Autowired
    private EspecialidadRepository EspecialidadRepo;

    public List<Especialidad> listarEspecialidades(){
        return EspecialidadRepo.findAll();
    }
}
