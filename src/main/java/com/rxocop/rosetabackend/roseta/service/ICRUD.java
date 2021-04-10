package com.rxocop.rosetabackend.roseta.service;

import java.util.List;
import java.util.Optional;

public interface ICRUD<T, V> {
    T registrar(T obj);

    T modificar(T obj);

    List<T> listar();

    Optional<T> listarPorId(V id);

    boolean eliminar(V id);
}
