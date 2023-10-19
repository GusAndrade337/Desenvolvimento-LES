package com.flow.api.controller;

import com.flow.api.dto.CreateFlowRequestDTO;
import com.flow.api.dto.CreateFlowResponseDTO;
import com.flow.api.dto.RetrieveFlowRequestDTO;
import com.flow.api.entity.FlowEntity;
import com.flow.api.mapper.FlowMapper;
import com.flow.api.repository.FlowRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Flow")
public class FlowController {

    @Autowired
    private FlowRepository repository;

    @Autowired
    private FlowMapper mapper;

    @PostMapping
    @Transactional
    public CreateFlowResponseDTO cadastrar(@RequestBody @Valid CreateFlowRequestDTO dados) {
        FlowEntity entity = mapper.toEntity(dados);
        FlowEntity response = repository.save(entity);
        return mapper.toResponsePost(response);
    }

    @GetMapping
    public Page<RetrieveFlowRequestDTO> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        Page<FlowEntity> lista = repository.findAll(paginacao);
        return mapper.toResponseGetPageable(lista);
    }


    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable int id) {
        repository.deleteById(id);
    }


}
