package com.example.aula.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.aula.model.ClienteModel;



@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel, Long>{
    Optional<ClienteModel> findByTelefone(String telefone);
}
