package com.usuarios.api.controller;

import com.usuarios.api.dto.CreateUsuariosRequestDTO;
import com.usuarios.api.dto.CreateUsuariosResponseDTO;
import com.usuarios.api.dto.RetrieveUsuariosRequestDTO;
import com.usuarios.api.entity.UsuariosEntity;
import com.usuarios.api.mapper.UsuariosMapper;
import com.usuarios.api.repository.UsuariosRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Usuarios")
public class UsuariosController {

    @Autowired
    private UsuariosRepository repository;

    @Autowired
    private UsuariosMapper mapper;

    @PostMapping
    @Transactional
    public CreateUsuariosResponseDTO cadastrar(@RequestBody @Valid CreateUsuariosRequestDTO dados) {
        UsuariosEntity entity = mapper.toEntity(dados);
        UsuariosEntity response = repository.save(entity);
        return mapper.toResponsePost(response);
    }

    @GetMapping
    public Page<RetrieveUsuariosRequestDTO> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        Page<UsuariosEntity> lista = repository.findAll(paginacao);
        return mapper.toResponseGetPageable(lista);
    }


    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable int id) {
        repository.deleteById(id);
    }


}
