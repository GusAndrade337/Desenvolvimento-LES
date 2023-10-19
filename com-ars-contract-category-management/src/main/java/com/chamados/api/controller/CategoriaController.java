package com.chamados.api.controller;

import com.chamados.api.dto.*;
import com.chamados.api.entity.CategoriaEntity;
import com.chamados.api.entity.FlowEntity;
import com.chamados.api.mapper.CategoriaMapper;
import com.chamados.api.repository.CategoriaRepository;
import com.chamados.api.repository.FlowRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository repository;

    @Autowired
    private FlowRepository flowRepository;

    @Autowired
    private CategoriaMapper mapper;

    @PostMapping
    @Transactional
    public CreateCategoriaResponseDTO cadastrar(@RequestBody @Valid CreateCategoriaRequestDTO dados) {
        CategoriaEntity entity = mapper.toEntity(dados);
        CategoriaEntity response = repository.save(entity);
        return mapper.toResponsePost(response);
    }

    @PostMapping("/{id}/cadastrarFluxo")
    @Transactional
    public ResponseEntity cadastrarFluxo(
            @PathVariable int id,
            @RequestBody AssociateFlowDTO dados) {
        for(FlowDTO flow : dados.getFlow()){
            FlowEntity entity = new FlowEntity();
            entity.setId(id);
            entity.setId_origin(flow.getId_origin());
            entity.setId_destination(flow.getId_destination());
            flowRepository.save(entity);
        }
        return ResponseEntity.status(201).build();
    }

    @GetMapping
    public Page<RetrieveCategoriaRequestDTO> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        Page<CategoriaEntity> lista = repository.findAll(paginacao);
        return mapper.toResponseGetPageable(lista);
    }


    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable int id) {
        repository.deleteById(id);
    }


}
