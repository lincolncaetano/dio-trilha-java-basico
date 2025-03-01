package com.lincolncaetano.springgof.controller;

import com.lincolncaetano.springgof.model.Cliente;
import com.lincolncaetano.springgof.service.ClienteService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/cliente")
public class ClieteRestController {

    private final ClienteService service;

    public ClieteRestController(ClienteService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Iterable<Cliente>> buscaTodos(){
        return ResponseEntity.ok(service.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscaPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Cliente> salvaCliente(@RequestBody Cliente cliente){
        service.inserir(cliente);
        URI location = URI.create("/cliente/" + cliente.getId());
        return ResponseEntity.created(location).body(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizaCliente(@PathVariable Long id, @RequestBody Cliente cliente){
        service.atualizar(id, cliente);
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletaCliente(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.ok().build();
    }


}
