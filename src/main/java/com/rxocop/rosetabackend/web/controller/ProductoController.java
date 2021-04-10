package com.rxocop.rosetabackend.web.controller;

import com.rxocop.rosetabackend.persistence.entity.Producto;
import com.rxocop.rosetabackend.persistence.inter.ProductoRepositoryInt;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private ProductoRepositoryInt repositoryInt;

    @GetMapping("/all")
    @ApiOperation("Obtiene todos los productos del supermercado")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<Producto>> getAll(){
        return new ResponseEntity<>(repositoryInt.listar(), HttpStatus.OK) ;
    }

    @GetMapping("/{id}")
    @ApiOperation("Busca producto por ID")
    @ApiResponses({
            @ApiResponse(code = 200,message = "OK"),
            @ApiResponse(code = 400,message = "Producto no encontrado")
    })
    public ResponseEntity<Producto> getProductoById(@ApiParam(value = "El id del producto",required = true, example = "1") @PathVariable("id") Integer id){
        return repositoryInt.listarPorId(id).map(producto -> new ResponseEntity<>(producto,HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/category/{id}")
    public  ResponseEntity<List<Producto>> getByCategoria(@PathVariable("id") Integer id){
        return new ResponseEntity<>(repositoryInt.getByCategoria(id), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Producto> guardar(@RequestBody Producto producto){
        return  new ResponseEntity<>(repositoryInt.registrar(producto), HttpStatus.CREATED);
    }

    @PutMapping("/edit")
    public Producto modificar(@RequestBody Producto producto){
        return repositoryInt.modificar(producto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id){
        return repositoryInt.eliminar(id) ? new ResponseEntity(HttpStatus.OK): new ResponseEntity(HttpStatus.NOT_FOUND);
    }






}
