package com.flow.api.mapper;

import com.flow.api.entity.FlowEntity;
import com.flow.api.dto.CreateFlowRequestDTO;
import com.flow.api.dto.CreateFlowResponseDTO;
import com.flow.api.dto.RetrieveFlowRequestDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class FlowMapper {

    public RetrieveFlowRequestDTO toResponseGet(FlowEntity entity) {

        if (Objects.isNull(entity)) return null;

        var response =
                RetrieveFlowRequestDTO.builder()
                        .id(entity.getId())
                        .nome(entity.getNome())
                        .descricao(entity.getDescricao())
                        .build();
        return response;
    }

    public Page<RetrieveFlowRequestDTO> toResponseGetPageable(
            Page<FlowEntity> entityPage) {

        if (Objects.isNull(entityPage)) return null;

        return entityPage.map(this::toResponseGet);
    }

    public CreateFlowResponseDTO toResponsePost(FlowEntity entity) {

        if (Objects.isNull(entity)) return null;

        var response = CreateFlowResponseDTO.builder().id(entity.getId()).build();

        return response;
    }

    public FlowEntity toEntity(CreateFlowRequestDTO request) {
        if (Objects.isNull(request)) {
            return null;
        } else {
            return FlowEntity.builder()
                    .nome(request.getNome())
                    .descricao(request.getDescricao())
                    .build();
        }
    }
}
