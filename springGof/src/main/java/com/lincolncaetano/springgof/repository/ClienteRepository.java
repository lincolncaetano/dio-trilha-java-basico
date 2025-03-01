package com.lincolncaetano.springgof.repository;

import com.lincolncaetano.springgof.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
