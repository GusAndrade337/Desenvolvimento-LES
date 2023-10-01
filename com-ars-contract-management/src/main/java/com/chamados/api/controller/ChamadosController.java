package com.chamados.api.controller;

import com.chamados.api.dto.CreateChamadosRequestDTO;
import com.chamados.api.dto.CreateChamadosResponseDTO;
import com.chamados.api.dto.RetrieveChamadosRequestDTO;
import com.chamados.api.entity.ChamadosEntity;
import com.chamados.api.mapper.ChamadosMapper;
import com.chamados.api.repository.ChamadosRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Chamados")
public class ChamadosController {

    @Autowired
    private ChamadosRepository repository;

    @Autowired
    private ChamadosMapper mapper;

    @PostMapping
    @Transactional
    public CreateChamadosResponseDTO cadastrar(@RequestBody @Valid CreateChamadosRequestDTO dados) {
        ChamadosEntity entity = mapper.toEntity(dados);
        ChamadosEntity response = repository.save(entity);
        return mapper.toResponsePost(response);
    }

    @GetMapping
    public Page<RetrieveChamadosRequestDTO> listar(@PageableDefault(size = 10, sort = {"titulo"}) Pageable paginacao) {
        Page<ChamadosEntity> lista = repository.findAll(paginacao);
        return mapper.toResponseGetPageable(lista);
    }


    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable int id) {
        repository.deleteById(id);
    }


}
