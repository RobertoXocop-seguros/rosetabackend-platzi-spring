package com.rxocop.rosetabackend.persistence.crud;

import com.rxocop.rosetabackend.persistence.entity.Compra;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CompraCrudRepository extends CrudRepository<Compra,Integer> {
    Optional<List<Compra>> getAllByIdCliente(String idCliente);
}
