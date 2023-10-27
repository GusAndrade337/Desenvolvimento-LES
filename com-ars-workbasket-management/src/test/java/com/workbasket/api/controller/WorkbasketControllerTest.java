package com.workbasket.api.controller;

import com.workbasket.api.dto.CreateWorkbasketRequestDTO;
import com.workbasket.api.dto.CreateWorkbasketResponseDTO;
import com.workbasket.api.dto.RetrieveWorkbasketRequestDTO;
import com.workbasket.api.entity.WorkbasketEntity;
import com.workbasket.api.mapper.WorkbasketMapper;
import com.workbasket.api.repository.WorkbasketRepository;
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

class WorkbasketControllerTest {
    @InjectMocks
    WorkbasketController controller;

    @Mock
    WorkbasketMapper mapper;

    @Mock
    WorkbasketRepository repository;

    @Test
    void should_return_200_get(){
        List<RetrieveWorkbasketRequestDTO> dtoList = new ArrayList<>();
        Page<RetrieveWorkbasketRequestDTO> dto = new PageImpl<>(dtoList);
        PageRequest pageRequest = PageRequest.of(0,1);
        List<WorkbasketEntity> entityList = new ArrayList<>();
        Page<WorkbasketEntity> lista = new PageImpl<>(entityList);
        Mockito.when(repository.findAll(pageRequest)).thenReturn(lista);
        Mockito.when(mapper.toResponseGetPageable(lista)).thenReturn(dto);

        Page<RetrieveWorkbasketRequestDTO> dtoResponse = controller.listar(pageRequest);
        Assertions.assertEquals(dtoResponse.toString(),dto.toString());
    }

    @Test
    void should_return_id_Post(){
        CreateWorkbasketRequestDTO dados = new CreateWorkbasketRequestDTO();
        CreateWorkbasketResponseDTO response = new CreateWorkbasketResponseDTO();
        WorkbasketEntity entity = new WorkbasketEntity();
        Mockito.when(repository.save(entity)).thenReturn(entity);
        Mockito.when(mapper.toEntity(dados)).thenReturn(entity);
        Mockito.when(mapper.toResponsePost(entity)).thenReturn(response);

        CreateWorkbasketResponseDTO responseDTO2 = controller.cadastrar(dados);
        Assertions.assertEquals(responseDTO2,response);
    }

    @Test
    void should_call_delete(){
        controller.excluir(1);
        Mockito.verify(repository).deleteById(1);
    }
}