package com.rxocop.rosetabackend.roseta.service.impl;

import com.rxocop.rosetabackend.roseta.model.Estudiante;
import com.rxocop.rosetabackend.roseta.repo.IEstudianteRepo;
import com.rxocop.rosetabackend.roseta.service.IEstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteServiceImpl implements IEstudianteService {

    @Autowired
    private IEstudianteRepo repo;

    @Override
    public Estudiante registrar(Estudiante obj) {
        return this.repo.save(obj);
    }

    @Override
    public Estudiante modificar(Estudiante obj) {
        return this.repo.save(obj);
    }

    @Override
    public List<Estudiante> listar() {
        return this.repo.findAll();
    }

    @Override
    public Optional<Estudiante> listarPorId(Integer id) {
        Optional<Estudiante> op = this.repo.findById(id);
        //return op.isPresent() ? op.get() : new Estudiante();
        return  op;
    }

    @Override
    public boolean eliminar(Integer id) {
        this.repo.deleteById(id);
        return true;
    }
}
