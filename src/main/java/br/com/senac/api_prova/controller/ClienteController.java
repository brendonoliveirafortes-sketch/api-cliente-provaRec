package br.com.senac.api_prova.controller;


import br.com.senac.api_prova.dtos.ClienteDTO;
import br.com.senac.api_prova.entidade.ClienteEntidade;
import br.com.senac.api_prova.repositorio.ClienteRepositorio;
import br.com.senac.api_prova.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/listar")
    public ResponseEntity<List<ClienteEntidade>> listar() {
        return ResponseEntity.ok(clienteService.listar());
    }


    @PostMapping("/criar")
    public ResponseEntity<ClienteEntidade> criar(
            @RequestBody ClienteDTO cliente) {
        try {
            return ResponseEntity.ok(clienteService.criar(cliente));
        } catch (RuntimeException e) {
            e.printStackTrace();
            return ResponseEntity
                    .badRequest()
                    .body(null);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity
                    .internalServerError()
                    .body(null);
        }
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<ClienteEntidade> atualizar(
            @PathVariable Long id,
            @RequestBody ClienteDTO cliente) {
        try {
            return ResponseEntity
                    .ok(clienteService.atualizar(id, cliente));
        } catch (RuntimeException e) {
            e.printStackTrace();
            return ResponseEntity
                    .badRequest()
                    .body(null);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity
                    .internalServerError()
                    .body(null);
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        try {
            clienteService.deletar(id);
            return ResponseEntity.ok(null);
        } catch (RuntimeException e) {
            e.printStackTrace();
            return ResponseEntity
                    .badRequest()
                    .body(null);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity
                    .internalServerError()
                    .body(null);
        }
    }
}