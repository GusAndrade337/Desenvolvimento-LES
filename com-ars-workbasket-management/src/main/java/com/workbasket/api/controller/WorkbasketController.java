package com.workbasket.api.controller;

import com.workbasket.api.dto.CreateWorkbasketRequestDTO;
import com.workbasket.api.dto.CreateWorkbasketResponseDTO;
import com.workbasket.api.dto.RetrieveWorkbasketRequestDTO;
import com.workbasket.api.entity.WorkbasketEntity;
import com.workbasket.api.mapper.WorkbasketMapper;
import com.workbasket.api.repository.WorkbasketRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/WorkBasket")
public class WorkbasketController {

    @Autowired
    private WorkbasketRepository repository;

    @Autowired
    private WorkbasketMapper mapper;

    @PostMapping
    @Transactional
    public CreateWorkbasketResponseDTO cadastrar(@RequestBody @Valid CreateWorkbasketRequestDTO dados) {
        WorkbasketEntity entity = mapper.toEntity(dados);
        WorkbasketEntity response = repository.save(entity);
        return mapper.toResponsePost(response);
    }

    @GetMapping
    public Page<RetrieveWorkbasketRequestDTO> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        Page<WorkbasketEntity> lista = repository.findAll(paginacao);
        return mapper.toResponseGetPageable(lista);
    }


    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable int id) {
        repository.deleteById(id);
    }


}
