package com.example.aula.controller;

import com.example.aula.model.ClienteModel;
import com.example.aula.service.ClienteService;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<ClienteModel> listarClientes() {
        return clienteService.listarTodos();
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> salvarCliente(@RequestBody ClienteModel cliente){
        clienteService.salvarCliente(cliente);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("mensagem", "Cadastrado com sucesso"));
    }

    @PostMapping("/{id}")
    public ResponseEntity<Map<String, Object>> atualizar(@PathVariable Long id, @RequestBody ClienteModel cliente){
        clienteService.atuallizar(id, cliente);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("mensagem", "Atualizado com sucesso"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deletar(@PathVariable Long id){
        clienteService.deletar(id);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("mensagem", "Deletado com sucesso"));
    }
}
