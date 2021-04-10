package com.rxocop.rosetabackend.persistence.inter;

import com.rxocop.rosetabackend.persistence.entity.Producto;
import com.rxocop.rosetabackend.roseta.service.ICRUD;

import java.util.List;
import java.util.Optional;

public interface ProductoRepositoryInt  extends ICRUD<Producto, Integer> {
    List<Producto> getByCategoria(int idCategoria);
    Optional<List<Producto>> getEscasos(int cantidadStock, boolean estado);
}
