package com.lincolncaetano.springgof.repository;

import com.lincolncaetano.springgof.model.Cliente;
import com.lincolncaetano.springgof.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, String> {
}
