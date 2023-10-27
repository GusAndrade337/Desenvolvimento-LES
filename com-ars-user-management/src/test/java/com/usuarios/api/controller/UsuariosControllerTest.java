package com.usuarios.api.controller;

import com.usuarios.api.dto.CreateUsuariosRequestDTO;
import com.usuarios.api.dto.CreateUsuariosResponseDTO;
import com.usuarios.api.dto.RetrieveUsuariosRequestDTO;
import com.usuarios.api.entity.UsuariosEntity;
import com.usuarios.api.mapper.UsuariosMapper;
import com.usuarios.api.repository.UsuariosRepository;
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

class UsuariosControllerTest {

    @InjectMocks
    UsuariosController controller;

    @Mock
    UsuariosMapper mapper;

    @Mock
    UsuariosRepository repository;

    @Test
    void should_return_200_get(){
        List<RetrieveUsuariosRequestDTO> dtoList = new ArrayList<>();
        Page<RetrieveUsuariosRequestDTO> dto = new PageImpl<>(dtoList);
        PageRequest pageRequest = PageRequest.of(0,1);
        List<UsuariosEntity> entityList = new ArrayList<>();
        Page<UsuariosEntity> lista = new PageImpl<>(entityList);
        Mockito.when(repository.findAll(pageRequest)).thenReturn(lista);
        Mockito.when(mapper.toResponseGetPageable(lista)).thenReturn(dto);

        Page<RetrieveUsuariosRequestDTO> dtoResponse = controller.listar(pageRequest);
        Assertions.assertEquals(dtoResponse.toString(),dto.toString());
    }

    @Test
    void should_return_id_Post(){
        CreateUsuariosRequestDTO dados = new CreateUsuariosRequestDTO();
        CreateUsuariosResponseDTO response = new CreateUsuariosResponseDTO();
        UsuariosEntity entity = new UsuariosEntity();
        Mockito.when(repository.save(entity)).thenReturn(entity);
        Mockito.when(mapper.toEntity(dados)).thenReturn(entity);
        Mockito.when(mapper.toResponsePost(entity)).thenReturn(response);

        CreateUsuariosResponseDTO responseDTO2 = controller.cadastrar(dados);
        Assertions.assertEquals(responseDTO2,response);
    }

    @Test
    void should_call_delete(){
        controller.excluir(1);
        Mockito.verify(repository).deleteById(1);
    }
}