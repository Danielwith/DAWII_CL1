package com.cibertec.DAWll.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "especialidad")
public class Especialidad {
    @Id
    @Column(name = "IdEsp")
    private String idEsp;

    @Column(name = "NomEsp")
    private String nomEspecialidad;

    @Column(name = "Costo")
    private Double costo;
}
