package com.chamados.api.mapper;

import com.chamados.api.dto.CreateCategoriaRequestDTO;
import com.chamados.api.dto.CreateCategoriaResponseDTO;
import com.chamados.api.dto.RetrieveCategoriaRequestDTO;
import com.chamados.api.entity.CategoriaEntity;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CategoriaMapper {

    public RetrieveCategoriaRequestDTO toResponseGet(CategoriaEntity entity) {

        if (Objects.isNull(entity)) return null;

        var response =
                RetrieveCategoriaRequestDTO.builder()
                        .id(entity.getId())
                        .nome(entity.getNome())
                        .descricao(entity.getDescricao())
                        .validade(entity.getValidade())
                        .workBasketId(entity.getWorkBasketId())
                        .build();
        return response;
    }

    public Page<RetrieveCategoriaRequestDTO> toResponseGetPageable(
            Page<CategoriaEntity> entityPage) {

        if (Objects.isNull(entityPage)) return null;

        return entityPage.map(this::toResponseGet);
    }

    public CreateCategoriaResponseDTO toResponsePost(CategoriaEntity entity) {

        if (Objects.isNull(entity)) return null;

        var response = CreateCategoriaResponseDTO.builder().id(entity.getId()).build();

        return response;
    }

    public CategoriaEntity toEntity(CreateCategoriaRequestDTO request) {
        if (Objects.isNull(request)) {
            return null;
        } else {
            return CategoriaEntity.builder()
                    .nome(request.getNome())
                    .descricao(request.getDescricao())
                    .validade(request.getValidade())
                    .workBasketId(request.getWorkBasketId())
                    .build();
        }
    }
}
