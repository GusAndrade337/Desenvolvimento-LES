package com.role.api.controller;

import com.role.api.dto.RetrieveRoleRequestDTO;
import com.role.api.entity.RoleEntity;
import com.role.api.mapper.RoleMapper;
import com.role.api.repository.RoleRepository;
import com.role.api.dto.CreateRoleRequestDTO;
import com.role.api.dto.CreateRoleResponseDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Role")
public class RoleController {

    @Autowired
    private RoleRepository repository;

    @Autowired
    private RoleMapper mapper;

    @PostMapping
    @Transactional
    public CreateRoleResponseDTO cadastrar(@RequestBody @Valid CreateRoleRequestDTO dados) {
        RoleEntity entity = mapper.toEntity(dados);
        RoleEntity response = repository.save(entity);
        return mapper.toResponsePost(response);
    }

    @GetMapping
    public Page<RetrieveRoleRequestDTO> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        Page<RoleEntity> lista = repository.findAll(paginacao);
        return mapper.toResponseGetPageable(lista);
    }


    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable int id) {
        repository.deleteById(id);
    }


}
