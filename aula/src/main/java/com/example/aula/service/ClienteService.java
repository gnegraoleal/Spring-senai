package com.example.aula.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.aula.model.ClienteModel;
import com.example.aula.repository.ClienteRepository;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<ClienteModel> listarTodos(){
        return clienteRepository.findAll();
    }

    public ClienteModel salvarCliente(ClienteModel cliente) {
        if(clienteRepository.findByTelefone(cliente.getTelefone()).isPresent()){
            throw new IllegalArgumentException("Cliente já cadastrado com esse telefone");
        }
        return clienteRepository.save(cliente);
    }

    public ClienteModel atuallizar(Long id, ClienteModel cliente){
        if(!clienteRepository.existsById(id)){
            throw new RuntimeException("Cliente não encontrado");
        }
        cliente.setId(id);
        return clienteRepository.save(cliente);
    }

    public void deletar(Long id){
        if(!clienteRepository.existsById(id)){
            throw new RuntimeException("Cliente não encontrado");
        }
        clienteRepository.deleteById(id);
    }
}
