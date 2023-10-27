package com.chamados.api.controller;

import com.chamados.api.dto.CreateCategoriaRequestDTO;
import com.chamados.api.dto.CreateCategoriaResponseDTO;
import com.chamados.api.dto.RetrieveCategoriaRequestDTO;
import com.chamados.api.entity.CategoriaEntity;
import com.chamados.api.mapper.CategoriaMapper;
import com.chamados.api.repository.CategoriaRepository;
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
class CategoriaControllerTest {

    @InjectMocks
    CategoriaController controller;

    @Mock
    CategoriaMapper mapper;

    @Mock
    CategoriaRepository repository;

    @Test
    void should_return_200_get(){
        List<RetrieveCategoriaRequestDTO> dtoList = new ArrayList<>();
        Page<RetrieveCategoriaRequestDTO> dto = new PageImpl<>(dtoList);
        PageRequest pageRequest = PageRequest.of(0,1);
        List<CategoriaEntity> entityList = new ArrayList<>();
        Page<CategoriaEntity> lista = new PageImpl<>(entityList);
        Mockito.when(repository.findAll(pageRequest)).thenReturn(lista);
        Mockito.when(mapper.toResponseGetPageable(lista)).thenReturn(dto);

        Page<RetrieveCategoriaRequestDTO> dtoResponse = controller.listar(pageRequest);
        Assertions.assertEquals(dtoResponse.toString(),dto.toString());
    }

    @Test
    void should_return_id_Post(){
        CreateCategoriaRequestDTO dados = new CreateCategoriaRequestDTO();
        CreateCategoriaResponseDTO response = new CreateCategoriaResponseDTO();
        CategoriaEntity entity = new CategoriaEntity();
        Mockito.when(repository.save(entity)).thenReturn(entity);
        Mockito.when(mapper.toEntity(dados)).thenReturn(entity);
        Mockito.when(mapper.toResponsePost(entity)).thenReturn(response);

        CreateCategoriaResponseDTO responseDTO2 = controller.cadastrar(dados);
        Assertions.assertEquals(responseDTO2,response);
    }

    @Test
    void should_call_delete(){
        controller.excluir(1);
        Mockito.verify(repository).deleteById(1);
    }
}