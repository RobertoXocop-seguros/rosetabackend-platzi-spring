package com.rxocop.rosetabackend.roseta.controller;

import com.rxocop.rosetabackend.roseta.model.Estudiante;
import com.rxocop.rosetabackend.roseta.service.IEstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/estudiante")
public class EstudianteController {

    @Autowired
    private IEstudianteService service;

    @GetMapping(value = {"", "/"})
    public ResponseEntity<List<Estudiante>> listar() {
        List<Estudiante> list = this.service.listar();
        return new ResponseEntity<List<Estudiante>>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Estudiante>> listarId(@PathVariable("id") Integer id) {
        //Estudiante estudiante = this.service.listarPorId(id);
        return new ResponseEntity<Optional<Estudiante>>(this.service.listarPorId(id), HttpStatus.OK);
    }

    @GetMapping("/rb/{id}")
    public @ResponseBody
    Optional<Estudiante> findById(@PathVariable Integer id) {
        return service.listarPorId(id);
    }

    @PostMapping
    public ResponseEntity<Estudiante> guardar(@RequestBody Estudiante es) {
        Estudiante estudiante = this.service.registrar(es);
        return new ResponseEntity<Estudiante>(es, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Estudiante> modificar(@RequestBody Estudiante es) {
        Estudiante estudiante = this.service.modificar(es);
        return new ResponseEntity<Estudiante>(estudiante, HttpStatus.OK);
    }

    @PutMapping("/rb")
    public @ResponseBody
    void update(@RequestBody Estudiante es) {
        service.modificar(es);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
        this.service.eliminar(id);
        return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
    }
}
