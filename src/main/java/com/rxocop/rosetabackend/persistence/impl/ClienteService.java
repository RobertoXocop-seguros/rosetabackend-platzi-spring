package com.rxocop.rosetabackend.persistence.impl;

import com.rxocop.rosetabackend.persistence.crud.ClienteCrudRepository;
import com.rxocop.rosetabackend.persistence.entity.Cliente;
import com.rxocop.rosetabackend.persistence.inter.ClienteRepositoryInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService  implements ClienteRepositoryInt {

    @Autowired
    private ClienteCrudRepository clienteCrudRepository;

    @Override
    public Cliente registrar(Cliente obj) {
        return clienteCrudRepository.save(obj);
    }

    @Override
    public Cliente modificar(Cliente obj) {
        return clienteCrudRepository.save(obj);
    }

    @Override
    public List<Cliente> listar() {
        return (List<Cliente>) clienteCrudRepository.findAll();
    }

    @Override
    public Optional<Cliente> listarPorId(Integer id) {
        return clienteCrudRepository.findById(id);
    }

    @Override
    public boolean eliminar(Integer id) {
        if (clienteCrudRepository.findById(id).isPresent()){
            clienteCrudRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
