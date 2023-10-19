package com.workbasket.api.mapper;

import com.workbasket.api.entity.WorkbasketEntity;
import com.workbasket.api.dto.CreateWorkbasketRequestDTO;
import com.workbasket.api.dto.CreateWorkbasketResponseDTO;
import com.workbasket.api.dto.RetrieveWorkbasketRequestDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class WorkbasketMapper {

    public RetrieveWorkbasketRequestDTO toResponseGet(WorkbasketEntity entity) {

        if (Objects.isNull(entity)) return null;

        var response =
                RetrieveWorkbasketRequestDTO.builder()
                        .id(entity.getId())
                        .nome(entity.getNome())
                        .descricao(entity.getDescricao())
                        .build();
        return response;
    }

    public Page<RetrieveWorkbasketRequestDTO> toResponseGetPageable(
            Page<WorkbasketEntity> entityPage) {

        if (Objects.isNull(entityPage)) return null;

        return entityPage.map(this::toResponseGet);
    }

    public CreateWorkbasketResponseDTO toResponsePost(WorkbasketEntity entity) {

        if (Objects.isNull(entity)) return null;

        var response = CreateWorkbasketResponseDTO.builder().id(entity.getId()).build();

        return response;
    }

    public WorkbasketEntity toEntity(CreateWorkbasketRequestDTO request) {
        if (Objects.isNull(request)) {
            return null;
        } else {
            return WorkbasketEntity.builder()
                    .nome(request.getNome())
                    .descricao(request.getDescricao())
                    .build();
        }
    }
}
