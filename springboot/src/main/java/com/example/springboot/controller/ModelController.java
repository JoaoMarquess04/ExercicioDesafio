package com.example.springboot.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.dtos.ModelDTO;


import com.example.springboot.service.ModelService;



@RestController
@RequestMapping("/cliente")
public class ModelController {

    @Autowired
    private ModelService modelService;



    // Endpoint para cadastrar/salvar um cliente
    @PostMapping
    public ResponseEntity<ModelDTO> salvar(@RequestBody ModelDTO modelDTO) {
        ModelDTO modelSalvo = modelService.salvar(modelDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(modelSalvo);
    }



    // Endpoint para listar todos os clientes
    @GetMapping
    public ResponseEntity<List<ModelDTO>> listar() {
        List<ModelDTO> models = modelService.listar();
        return ResponseEntity.ok(models);
    }



    // Endpoint para buscar um cliente por ID
    @GetMapping("/{id}")
    public ResponseEntity<ModelDTO> buscarPorId(@PathVariable Long id) {
        Optional<ModelDTO> modelDTO = modelService.buscarPorId(id);
        return modelDTO.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }



    // Endpoint para deletar um cliente
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        modelService.deletar(id);
        return ResponseEntity.noContent().build();
    }



    // Endpoint para pesquisar clientes por nome
    @GetMapping("/pesquisa")
    public ResponseEntity<List<ModelDTO>> pesquisarPorNome(@RequestParam String nome) {
        List<ModelDTO> models = modelService.pesquisarPorNome(nome);
        return ResponseEntity.ok(models);
    }



// Endpoint para alterar um cliente existente
    @PutMapping("/{id}")
    public ResponseEntity<ModelDTO> atualizar(@PathVariable Long id, @RequestBody ModelDTO modelDTO) {
        ModelDTO modelAtualizado = modelService.atualizar(id, modelDTO);
        return ResponseEntity.ok(modelAtualizado);
    }


}
