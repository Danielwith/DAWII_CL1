package com.cibertec.DAWll.repository;

import com.cibertec.DAWll.model.Especialidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspecialidadRepository extends JpaRepository<Especialidad, String> {
}
