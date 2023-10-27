package com.flow.api.controller;

import com.flow.api.dto.CreateFlowRequestDTO;
import com.flow.api.dto.CreateFlowResponseDTO;
import com.flow.api.dto.RetrieveFlowRequestDTO;
import com.flow.api.entity.FlowEntity;
import com.flow.api.mapper.FlowMapper;
import com.flow.api.repository.FlowRepository;
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

class FlowControllerTest {

    @InjectMocks
    FlowController controller;

    @Mock
    FlowMapper mapper;

    @Mock
    FlowRepository repository;

    @Test
    void should_return_200_get(){
        List<RetrieveFlowRequestDTO> dtoList = new ArrayList<>();
        Page<RetrieveFlowRequestDTO> dto = new PageImpl<>(dtoList);
        PageRequest pageRequest = PageRequest.of(0,1);
        List<FlowEntity> entityList = new ArrayList<>();
        Page<FlowEntity> lista = new PageImpl<>(entityList);
        Mockito.when(repository.findAll(pageRequest)).thenReturn(lista);
        Mockito.when(mapper.toResponseGetPageable(lista)).thenReturn(dto);

        Page<RetrieveFlowRequestDTO> dtoResponse = controller.listar(pageRequest);
        Assertions.assertEquals(dtoResponse.toString(),dto.toString());
    }

    @Test
    void should_return_id_Post(){
        CreateFlowRequestDTO dados = new CreateFlowRequestDTO();
        CreateFlowResponseDTO response = new CreateFlowResponseDTO();
        FlowEntity entity = new FlowEntity();
        Mockito.when(repository.save(entity)).thenReturn(entity);
        Mockito.when(mapper.toEntity(dados)).thenReturn(entity);
        Mockito.when(mapper.toResponsePost(entity)).thenReturn(response);

        CreateFlowResponseDTO responseDTO2 = controller.cadastrar(dados);
        Assertions.assertEquals(responseDTO2,response);
    }

    @Test
    void should_call_delete(){
        controller.excluir(1);
        Mockito.verify(repository).deleteById(1);
    }
}