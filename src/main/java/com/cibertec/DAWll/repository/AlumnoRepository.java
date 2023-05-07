package com.cibertec.DAWll.repository;

import com.cibertec.DAWll.model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno,String> {
    @Query(value = "SELECT MAX(CAST(RIGHT(IdAlumno, 4) AS UNSIGNED)) AS max FROM alumno", nativeQuery = true)
    public String maxIdCode();
}
