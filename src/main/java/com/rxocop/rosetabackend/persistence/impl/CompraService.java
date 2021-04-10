package com.rxocop.rosetabackend.persistence.impl;

import com.rxocop.rosetabackend.persistence.crud.CompraCrudRepository;
import com.rxocop.rosetabackend.persistence.entity.Compra;
import com.rxocop.rosetabackend.persistence.inter.CompraRepositoryInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompraService implements CompraRepositoryInt {

    @Autowired
    private CompraCrudRepository compraCrudRepository;


    @Override
    public Optional<List<Compra>> getByClient(String clientId) {
        return compraCrudRepository.getAllByIdCliente(clientId);
    }

    @Override
    public Compra registrar(Compra obj) {
        obj.getProductos().forEach(producto -> producto.setCompra(obj));
        return compraCrudRepository.save(obj);
    }

    @Override
    public Compra modificar(Compra obj) {
        return compraCrudRepository.save(obj);
    }

    @Override
    public List<Compra> listar() {
        return (List<Compra>) compraCrudRepository.findAll();
    }

    @Override
    public Optional<Compra> listarPorId(Integer id) {
        return compraCrudRepository.findById(id);
    }

    @Override
    public boolean eliminar(Integer id) {
        if (compraCrudRepository.findById(id).isPresent()) {
            compraCrudRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
