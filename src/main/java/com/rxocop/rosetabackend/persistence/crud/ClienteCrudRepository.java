package com.rxocop.rosetabackend.persistence.crud;

import com.rxocop.rosetabackend.persistence.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteCrudRepository extends CrudRepository<Cliente,Integer> {
}
