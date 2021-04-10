package com.rxocop.rosetabackend.web.controller;

import com.rxocop.rosetabackend.persistence.entity.Compra;
import com.rxocop.rosetabackend.persistence.inter.CompraRepositoryInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compras")
public class CompraController {

    @Autowired
    private CompraRepositoryInt compraRepositoryInt;

    @GetMapping("/all")
    public ResponseEntity<List<Compra>> getAll(){
        return new ResponseEntity<>(compraRepositoryInt.listar(), HttpStatus.OK);
    }

    @GetMapping("/cliente/{id}")
    public ResponseEntity getAllByIdCliente(@PathVariable("id") String id){
        return compraRepositoryInt.getByClient(id).map(compras -> new ResponseEntity<>(compras,HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<Compra> agregar(@RequestBody Compra compra){
        return new ResponseEntity<>(compraRepositoryInt.registrar(compra),HttpStatus.CREATED);
    }
}
