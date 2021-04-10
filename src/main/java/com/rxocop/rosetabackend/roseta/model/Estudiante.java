package com.rxocop.rosetabackend.roseta.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "estudiante")
public class Estudiante {

    @Id
    @Column(name = "id_estudiante")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEstudiante;

    @Column(name = "genero")
    private String Genero;

    @Column(name = "fecha_nacimiento")
    private LocalDateTime FechaNacimiento;

    @Column(name = "aliase")
    private String Aliase;

    public Integer getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Integer idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String genero) {
        Genero = genero;
    }

    public LocalDateTime getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
        FechaNacimiento = fechaNacimiento;
    }

    public String getAliase() {
        return Aliase;
    }

    public void setAliase(String aliase) {
        Aliase = aliase;
    }
}
