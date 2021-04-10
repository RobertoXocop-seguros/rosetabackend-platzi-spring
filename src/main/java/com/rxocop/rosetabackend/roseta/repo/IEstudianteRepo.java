package com.rxocop.rosetabackend.roseta.repo;


import com.rxocop.rosetabackend.roseta.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEstudianteRepo extends JpaRepository<Estudiante, Integer> {
}
