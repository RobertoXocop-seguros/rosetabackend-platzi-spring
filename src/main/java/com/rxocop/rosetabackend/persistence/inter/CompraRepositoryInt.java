package com.rxocop.rosetabackend.persistence.inter;

import com.rxocop.rosetabackend.persistence.entity.Compra;
import com.rxocop.rosetabackend.roseta.service.ICRUD;

import java.util.List;
import java.util.Optional;

public interface CompraRepositoryInt extends ICRUD<Compra,Integer> {
    Optional<List<Compra>> getByClient(String clientId);
}
