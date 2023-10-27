package com.role.api.controller;

import com.role.api.dto.CreateRoleRequestDTO;
import com.role.api.dto.CreateRoleResponseDTO;
import com.role.api.dto.RetrieveRoleRequestDTO;
import com.role.api.entity.RoleEntity;
import com.role.api.mapper.RoleMapper;
import com.role.api.repository.RoleRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)

class RoleControllerTest {

    @InjectMocks
    RoleController controller;

    @Mock
    RoleMapper mapper;

    @Mock
    RoleRepository repository;

    @Test
    void should_return_200_get(){
        List<RetrieveRoleRequestDTO> dtoList = new ArrayList<>();
        Page<RetrieveRoleRequestDTO> dto = new PageImpl<>(dtoList);
        PageRequest pageRequest = PageRequest.of(0,1);
        List<RoleEntity> entityList = new ArrayList<>();
        Page<RoleEntity> lista = new PageImpl<>(entityList);
        Mockito.when(repository.findAll(pageRequest)).thenReturn(lista);
        Mockito.when(mapper.toResponseGetPageable(lista)).thenReturn(dto);

        Page<RetrieveRoleRequestDTO> dtoResponse = controller.listar(pageRequest);
        Assertions.assertEquals(dtoResponse.toString(),dto.toString());
    }

    @Test
    void should_return_id_Post(){
        CreateRoleRequestDTO dados = new CreateRoleRequestDTO();
        CreateRoleResponseDTO response = new CreateRoleResponseDTO();
        RoleEntity entity = new RoleEntity();
        Mockito.when(repository.save(entity)).thenReturn(entity);
        Mockito.when(mapper.toEntity(dados)).thenReturn(entity);
        Mockito.when(mapper.toResponsePost(entity)).thenReturn(response);

        CreateRoleResponseDTO responseDTO2 = controller.cadastrar(dados);
        Assertions.assertEquals(responseDTO2,response);
    }

    @Test
    void should_call_delete(){
        controller.excluir(1);
        Mockito.verify(repository).deleteById(1);
    }
}