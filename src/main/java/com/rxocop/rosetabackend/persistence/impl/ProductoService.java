package com.rxocop.rosetabackend.persistence.impl;

import com.rxocop.rosetabackend.persistence.crud.ProductoCrudRepository;
import com.rxocop.rosetabackend.persistence.entity.Producto;
import com.rxocop.rosetabackend.persistence.inter.ProductoRepositoryInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService implements ProductoRepositoryInt {

    @Autowired
    private ProductoCrudRepository productoCrudRepository;

    @Override
    public Producto registrar(Producto obj) {
        return this.productoCrudRepository.save(obj);
    }

    @Override
    public Producto modificar(Producto obj) {
        return this.productoCrudRepository.save(obj);
    }

    @Override
    public List<Producto> listar() {
        return (List<Producto>) this.productoCrudRepository.findAll();
    }

    @Override
    public Optional<Producto> listarPorId(Integer id) {
        Optional<Producto> op = this.productoCrudRepository.findById(id);

//        return op.isPresent()? op.get() : new Producto();
        return  op;
    }

    @Override
    public boolean eliminar(Integer id) {
        if (productoCrudRepository.findById(id).isPresent()){
            this.productoCrudRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Producto> getByCategoria(int idCategoria){
        return productoCrudRepository.findByIdCategoria(idCategoria);
    }

    @Override
    public Optional<List<Producto>> getEscasos(int cantidad,boolean estado){
        return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad,true);
    }
}
