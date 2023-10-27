package com.chamados.api.controller;

import com.chamados.api.dto.CreateChamadosRequestDTO;
import com.chamados.api.dto.CreateChamadosResponseDTO;
import com.chamados.api.dto.RetrieveChamadosRequestDTO;
import com.chamados.api.entity.ChamadosEntity;
import com.chamados.api.mapper.ChamadosMapper;
import com.chamados.api.repository.ChamadosRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
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
class ChamadosControllerTest {

    @InjectMocks
    ChamadosController controller;

    @Mock
    ChamadosMapper mapper;

    @Mock
    ChamadosRepository repository;

    @Test
    void should_return_200_get(){
        List<RetrieveChamadosRequestDTO> dtoList = new ArrayList<>();
        Page<RetrieveChamadosRequestDTO> dto = new PageImpl<>(dtoList);
        PageRequest pageRequest = PageRequest.of(0,1);
        List<ChamadosEntity> entityList = new ArrayList<>();
        Page<ChamadosEntity> lista = new PageImpl<>(entityList);
        Mockito.when(repository.findAll(pageRequest)).thenReturn(lista);
        Mockito.when(mapper.toResponseGetPageable(lista)).thenReturn(dto);

        Page<RetrieveChamadosRequestDTO> dtoResponse = controller.listar(pageRequest);
        Assertions.assertEquals(dtoResponse.toString(),dto.toString());
    }

    @Test
    void should_return_id_Post(){
        CreateChamadosRequestDTO dados = new CreateChamadosRequestDTO();
        CreateChamadosResponseDTO response = new CreateChamadosResponseDTO();
        ChamadosEntity entity = new ChamadosEntity();
        Mockito.when(repository.save(entity)).thenReturn(entity);
        Mockito.when(mapper.toEntity(dados)).thenReturn(entity);
        Mockito.when(mapper.toResponsePost(entity)).thenReturn(response);

        CreateChamadosResponseDTO responseDTO2 = controller.cadastrar(dados);
        Assertions.assertEquals(responseDTO2,response);
    }

    @Test
    void should_call_delete(){
        controller.excluir(1);
        Mockito.verify(repository).deleteById(1);
    }
}