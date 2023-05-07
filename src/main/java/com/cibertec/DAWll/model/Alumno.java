package com.cibertec.DAWll.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "alumno")
public class Alumno {
    @Id
    @Column(name = "IdAlumno")
    private String idAlumno;

    @Column(name = "ApeAlumno")
    private String apellido;

    @Column(name = "NomAlumno")
    private String nombre;

    @Column(name = "Proce")
    private String proce;

    @JsonIgnoreProperties
    @ManyToOne
    @JoinColumn(name = "idEsp")
    private Especialidad especialidad;
}
